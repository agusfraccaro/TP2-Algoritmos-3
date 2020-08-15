package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorAplicarBonus;
import edu.fiuba.algo3.controlador.ControladorEnviarRespuesta;
import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VistaPreguntas {
    private Kahoot kahoot;
    private Stage stage;
    List<ContenedorOpcion> botones = new ArrayList<ContenedorOpcion>();
    private int cantidadRespuestas = 0;
    private int inicio = 15;
    private Integer segundos = inicio;

    public VistaPreguntas(Kahoot kahoot, Stage stage){
        this.kahoot = kahoot;
        this.stage = stage;
    }

    public void mostrarPregunta(){
        if (cantidadRespuestas == 2)
            cantidadRespuestas = 0;
        cantidadRespuestas++;
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(30, 30, 30, 30));

        Label tiempo = new Label();
        tiempo.setId("tiempo");
        grid.add(tiempo, 0,1);

        ControladorEnviarRespuesta controladorEnviarRespuesta = new ControladorEnviarRespuesta(kahoot,this,stage,cantidadRespuestas,botones);
        (new Temporizador(tiempo,controladorEnviarRespuesta)).correrTiempo();

        Label lblJugadorActual = new Label("Turno de: " + kahoot.getJugadorActual().getNombre());
        Label puntaje = new Label("Puntos: " + kahoot.getJugadorActual().getPuntaje());
        grid.add(puntaje, 0, 3);
        grid.add(lblJugadorActual, 0, 2);

        Label lblPregunta = new Label( kahoot.getPreguntaActual().getTexto());
        grid.add(lblPregunta, 0, 4);

        new FabricaPanelOpciones().crearPanelParaOpciones(kahoot.getPreguntaActual(),grid,botones);

        new FabricaBotonBonus().crearBotonBonus(kahoot.getPreguntaActual(),grid, controladorEnviarRespuesta);

        grid.add(new BotonResponder(controladorEnviarRespuesta),1,8);

        Scene escena = new Scene(grid, 550, 450);
        File arch = new File("src/main/resources/styles/style.css");
        escena.getStylesheets().add("file:///" + arch.getAbsolutePath().replace("\\", "/")  );
        stage.setScene(escena);
    }
}
