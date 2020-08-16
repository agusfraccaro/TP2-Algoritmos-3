package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorEnviarRespuesta;
import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VistaPreguntas {
    private Kahoot kahoot;
    private Stage stage;
    List<ContenedorOpcion> botones = new ArrayList<>();
    private int cantidadRespuestas = 0;
    private int inicio = 15;
    private Integer segundos = inicio;

    public VistaPreguntas(Kahoot kahoot, Stage stage){
        this.kahoot = kahoot;
        this.stage = stage;
    }

    public void mostrarPregunta(){
        cantidadRespuestas %= 2;
        cantidadRespuestas++;
        /*
        Jugador         Timer
        Puntos          Bonus

                Pregunta

                Opciones

                Responder
         */
        Pane optionsPane = FabricaPanelOpciones.getOptionsPane(kahoot.getPreguntaActual());

        Button responderButton = new Button("RESPONDER");
        ControladorEnviarRespuesta controladorEnviarRespuesta = new ControladorEnviarRespuesta(kahoot, this, stage, cantidadRespuestas, optionsPane.getChildren());
        responderButton.setOnAction(controladorEnviarRespuesta);

        Label timer = new Label();
        timer.setId("tiempo");
        Temporizador temporizador = new Temporizador(timer, responderButton);
        temporizador.correrTiempo();
        controladorEnviarRespuesta.setTemporizador(temporizador);

        VBox bonusLayout = FabricaBotonBonus.crearBotonBonus(kahoot, controladorEnviarRespuesta);

        VBox timerAndBonusInfoLayout = new VBox();
        timerAndBonusInfoLayout.getChildren().addAll(timer, bonusLayout);
        timerAndBonusInfoLayout.setAlignment(Pos.TOP_RIGHT);

        VBox playerInfoLayout = new VBox();
        Label lblJugadorActual = new Label("Turno de: " + kahoot.getJugadorActual().getNombre());
        Label puntaje = new Label("Puntos: " + kahoot.getJugadorActual().getPuntaje());
        playerInfoLayout.getChildren().addAll(lblJugadorActual, puntaje);
        playerInfoLayout.setAlignment(Pos.BASELINE_LEFT);

        HBox header = new HBox();
        header.getChildren().addAll(playerInfoLayout, timerAndBonusInfoLayout);
        header.setSpacing(200);

        VBox questionLayout = new VBox();
        Label lblQuestion= new Label(kahoot.getPreguntaActual().getTexto());
        questionLayout.getChildren().addAll(lblQuestion, optionsPane);
        questionLayout.setPadding(new Insets(16, 16, 16, 16));
        questionLayout.setSpacing(70);
        questionLayout.setAlignment(Pos.CENTER);

        VBox mainLayout = new VBox();
        mainLayout.getChildren().addAll(header, questionLayout, responderButton);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(16, 16, 16, 16));
        mainLayout.setSpacing(50);

        Scene scene = new Scene(mainLayout, 550, 450);
        File my_style_file = new File("src/main/resources/styles/style.css");
        scene.getStylesheets().add("file:///" + my_style_file.getAbsolutePath().replace("\\", "/")  );

        stage.setScene(scene);
    }
}
