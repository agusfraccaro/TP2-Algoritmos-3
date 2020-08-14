package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorEnviarRespuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VistaPreguntas {
    private Kahoot kahoot;
    private Stage stage;
    List<CheckBox> radioButtons = new ArrayList<CheckBox>();
    private int cantidadRespuestas = 0;
    private int inicio = 15;
    private Integer segundos = inicio;

    public VistaPreguntas(Kahoot kahoot, Stage stage){
        this.kahoot = kahoot;
        this.stage = stage;
    }

    public void mostrarPregunta(){
        cantidadRespuestas++;
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(30, 30, 30, 30));

        Label tiempo = new Label();
        tiempo.setId("tiempo");
        grid.add(tiempo, 0,1);
        (new Temporizador(tiempo)).correrTiempo();

        Label lblJugadorActual = new Label("Turno de: " + kahoot.getJugadorActual());
        //arreglar, solo se ve el puntaje del 1er jugador
        List jugadores = kahoot.getJugadores();
        Jugador jug = (Jugador) jugadores.get(0);
        Label puntaje = new Label("Puntos: " + jug.getPuntaje());
        grid.add(puntaje, 0, 3);
        grid.add(lblJugadorActual, 0, 2);

        Label lblPregunta = new Label( kahoot.getPreguntaActual().getTexto());
        grid.add(lblPregunta, 0, 4);

        int i = 0;
        for (Opcion opcion : kahoot.getPreguntaActual().getOpciones()) {
            CheckBox rbOpcion = new CheckBox(opcion.getTexto());

            radioButtons.add(rbOpcion);
            grid.add(rbOpcion, 0, 5+i);
            i++;
        }

        Button btnResponder = new Button("Responder");
        btnResponder.setOnAction(new ControladorEnviarRespuesta(kahoot, this, stage, cantidadRespuestas));
        grid.add(btnResponder,1,6+i);

        Scene escena = new Scene(grid, 550, 450);
        File arch = new File("src/main/resources/styles/style.css");
        escena.getStylesheets().add("file:///" + arch.getAbsolutePath().replace("\\", "/")  );
        stage.setScene(escena);
    }
}
