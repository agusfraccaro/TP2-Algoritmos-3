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
import javafx.scene.text.Font;
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

    public void mostrarPregunta(){
        cantidadRespuestas %= 2;
        cantidadRespuestas++;

        Pane panelOpciones = FabricaPanelOpciones.getPanelOpciones(kahoot.getPreguntaActual());

        Font fontGeneral = Font.loadFont("file:src/main/resources/fonts/Skranji-Regular.ttf", 25);
        Font fontPregunta = Font.loadFont("file:src/main/resources/fonts/BalooTamma2-Medium.ttf", 25);

        Button botonResponder = new Button("RESPONDER");
        botonResponder.setFont(fontGeneral);

        ControladorEnviarRespuesta controladorEnviarRespuesta = new ControladorEnviarRespuesta(kahoot, this, stage, cantidadRespuestas, panelOpciones.getChildren());
        botonResponder.setOnAction(controladorEnviarRespuesta);

        Label labelTemporizador = new Label();
        labelTemporizador.setMinWidth(50);
        labelTemporizador.setId("tiempo");
        Temporizador temporizador = new Temporizador(labelTemporizador, botonResponder);
        temporizador.correrTiempo();

        HBox bonusLayout = FabricaBotonBonus.crearBotonBonus(kahoot, controladorEnviarRespuesta);

        VBox temporizadorLayout = new VBox();
        temporizadorLayout.setSpacing(5);
        temporizadorLayout.getChildren().addAll(labelTemporizador);
        temporizadorLayout.setAlignment(Pos.TOP_RIGHT);

        VBox infoJugadorLayout = new VBox();
        infoJugadorLayout.setSpacing(10);
        Label labelJugadorActual = new Label("Turno de: " + kahoot.getJugadorActual().getNombre());
        labelJugadorActual.setFont(fontGeneral);
        Label puntaje = new Label("Puntos: " + kahoot.getJugadorActual().getPuntaje());
        puntaje.setFont(fontGeneral);
        infoJugadorLayout.getChildren().addAll(labelJugadorActual, puntaje, bonusLayout);
        infoJugadorLayout.setAlignment(Pos.TOP_LEFT);

        HBox header = new HBox();
        header.getChildren().addAll(infoJugadorLayout, temporizadorLayout);
        header.setAlignment(Pos.CENTER);
        header.setSpacing(200);

        VBox preguntaLayout = new VBox();
        Label labelPregunta = new Label(kahoot.getPreguntaActual().getTexto());
        labelPregunta.setFont(fontPregunta);
        preguntaLayout.getChildren().addAll(labelPregunta, panelOpciones);
        preguntaLayout.setPadding(new Insets(16, 16, 16, 16));
        preguntaLayout.setSpacing(40);
        preguntaLayout.setAlignment(Pos.CENTER);

        VBox layoutPrincipal = new VBox();
        layoutPrincipal.getChildren().addAll(header, preguntaLayout, botonResponder);
        layoutPrincipal.setAlignment(Pos.CENTER);
        layoutPrincipal.setPadding(new Insets(30));
        layoutPrincipal.setSpacing(20);
        layoutPrincipal.setId("fondoPregunta");

        Scene scene = new Scene(layoutPrincipal, 700, 550);
        File archivo = new File("src/main/resources/styles/style.css");
        scene.getStylesheets().add("file:///" + archivo.getAbsolutePath().replace("\\", "/")  );

        stage.setScene(scene);
    }
}
