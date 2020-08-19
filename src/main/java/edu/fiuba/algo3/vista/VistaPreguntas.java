package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorEnviarRespuesta;
import edu.fiuba.algo3.controlador.ControladorMostrarInfoBonus;
import edu.fiuba.algo3.controlador.ControladorMostrarInfoPreguntas;
import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class VistaPreguntas {
    private final Kahoot kahoot;
    private final Stage stage;
    private int cantidadRespuestas = 0;

    public VistaPreguntas(Kahoot kahoot, Stage stage){
        this.kahoot = kahoot;
        this.stage = stage;
    }

    private void setBotonInfoBonus(HBox bonusLayout){
        Button botonInfo = new Button();
        botonInfo.setId("botonAyudaBonus");
        botonInfo.setCursor(Cursor.HAND);
        botonInfo.setOnAction(new ControladorMostrarInfoBonus(stage));
        bonusLayout.getChildren().add(botonInfo);
    }

    private void setBotonInfoPreguntas(VBox preguntasLayout){
        Button botonInfo = new Button();
        botonInfo.setId("botonAyudaBonus");
        botonInfo.setCursor(Cursor.HAND);
        botonInfo.setOnAction(new ControladorMostrarInfoPreguntas(stage));
        preguntasLayout.getChildren().add(botonInfo);
    }

    public void mostrarPregunta(){
        cantidadRespuestas %= 2;
        cantidadRespuestas++;

        Pane panelOpciones = FabricaPanelOpciones.getPanelOpciones(kahoot.getPreguntaActual());

        Label labelPregunta = new Label(kahoot.getPreguntaActual().getTexto());
        labelPregunta.setId("estiloPregunta");

        VBox preguntaLayout = new VBox();
        preguntaLayout.setId("layoutPregunta");
        preguntaLayout.getChildren().add(labelPregunta);
        setBotonInfoPreguntas(preguntaLayout);
        preguntaLayout.getChildren().add(panelOpciones);

        Button botonResponder = new Button("RESPONDER");
        botonResponder.setId("estiloJuegoGeneral");

        ControladorEnviarRespuesta controladorEnviarRespuesta = new ControladorEnviarRespuesta(kahoot, this, stage, cantidadRespuestas, panelOpciones.getChildren());
        botonResponder.setOnAction(controladorEnviarRespuesta);

        Label labelTemporizador = new Label();
        labelTemporizador.setId("labelTiempo");
        Temporizador temporizador = new Temporizador(labelTemporizador, botonResponder);
        temporizador.correrTiempo();

        VBox layoutTemporizador = new VBox();
        layoutTemporizador.setId("layoutTemporizador");
        layoutTemporizador.getChildren().addAll(labelTemporizador);

        HBox bonusLayout = FabricaBotonBonus.crearBotonBonus(kahoot, controladorEnviarRespuesta);
        setBotonInfoBonus(bonusLayout);

        Label labelJugadorActual = new Label("Turno de: " + kahoot.getJugadorActual().getNombre());
        Label puntaje = new Label("Puntos: " + kahoot.getJugadorActual().getPuntaje());
        VBox infoJugadorLayout = new VBox();
        infoJugadorLayout.setId("layoutInfoJugador");
        infoJugadorLayout.getChildren().addAll(labelJugadorActual, puntaje, bonusLayout);

        HBox header = new HBox();
        header.setId("header");
        header.getChildren().addAll(infoJugadorLayout, layoutTemporizador);

        VBox layoutPrincipal = new VBox();
        layoutPrincipal.setId("layoutPrincipal");
        layoutPrincipal.getChildren().addAll(header, preguntaLayout, botonResponder);

        Scene scene = new Scene(layoutPrincipal, 700, 550);
        File archivo = new File("src/main/resources/styles/style.css");
        scene.getStylesheets().add("file:///" + archivo.getAbsolutePath().replace("\\", "/")  );

        stage.setScene(scene);
    }
}
