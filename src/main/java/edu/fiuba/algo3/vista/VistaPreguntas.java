package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorEnviarRespuesta;
import edu.fiuba.algo3.controlador.ControladorMostrarInfoBonus;
import edu.fiuba.algo3.controlador.ControladorMostrarInfoPreguntas;
import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalsoConPenalidad;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.security.auth.callback.TextOutputCallback;
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
        botonInfo.setId("botonAyuda");
        botonInfo.setCursor(Cursor.HAND);
        botonInfo.setOnAction(new ControladorMostrarInfoBonus(stage));
        bonusLayout.getChildren().add(botonInfo);
    }

    private boolean tienePenalidad(){
        return (kahoot.getPreguntaActual() instanceof MultipleChoiceConPenalidad
                || kahoot.getPreguntaActual() instanceof VerdaderoFalsoConPenalidad);
    }

    private void setPenalidad(VBox infoJugadorLayout){
        Label penalidad = new Label();
        penalidad.setId("penalidad");
        Tooltip tooltip = new Tooltip();
        tooltip.setText("Por cada opción incorrecta se resta un punto!");
        penalidad.setTooltip(tooltip);
        infoJugadorLayout.getChildren().add(penalidad);
    }

    private Button setBotonInfoPreguntas(){
        Button botonInfo = new Button();
        botonInfo.setId("botonAyuda");
        botonInfo.setCursor(Cursor.HAND);
        botonInfo.setOnAction(new ControladorMostrarInfoPreguntas(stage));
        return botonInfo;
    }

    public void mostrarPregunta(){
        cantidadRespuestas %= 2;
        cantidadRespuestas++;

        Label labelPregunta = new Label(kahoot.getPreguntaActual().getTexto());
        labelPregunta.setId("estiloPregunta");

        Pane panelOpciones = FabricaPanelOpciones.getPanelOpciones(kahoot.getPreguntaActual());

        Button botonResponder = new Button("RESPONDER");
        botonResponder.setId("estiloJuegoGeneral");
        ControladorEnviarRespuesta controladorEnviarRespuesta = new ControladorEnviarRespuesta(kahoot, this, stage, cantidadRespuestas, panelOpciones.getChildren());
        botonResponder.setOnAction(controladorEnviarRespuesta);

        HBox contenedorAyudaYResponder = new HBox();
        contenedorAyudaYResponder.getChildren().addAll(botonResponder, setBotonInfoPreguntas());
        contenedorAyudaYResponder.setId("estiloContenedoresConAyuda");

        VBox preguntaLayout = new VBox();
        preguntaLayout.setId("layoutPregunta");
        preguntaLayout.getChildren().addAll(labelPregunta, panelOpciones, contenedorAyudaYResponder);

        Label labelTemporizador = new Label();
        labelTemporizador.setId("labelTiempo");
        Temporizador temporizador = new Temporizador(labelTemporizador, botonResponder);
        temporizador.correrTiempo();

        HBox bonusLayout = FabricaBotonBonus.crearBotonBonus(kahoot, controladorEnviarRespuesta);
        bonusLayout.setId("estiloContenedoresConAyuda");
        setBotonInfoBonus(bonusLayout);

        Label labelJugadorActual = new Label("Turno de: " + kahoot.getJugadorActual().getNombre());
        Label puntaje = new Label("Puntos: " + kahoot.getJugadorActual().getPuntaje());
        VBox infoJugadorLayout = new VBox();
        infoJugadorLayout.setId("layoutInfoJugador");
        if (tienePenalidad()){
            infoJugadorLayout.getChildren().addAll(labelJugadorActual, puntaje, bonusLayout);
            setPenalidad(infoJugadorLayout);
        }
        else infoJugadorLayout.getChildren().addAll(labelJugadorActual, puntaje, bonusLayout);

        HBox header = new HBox();
        header.setId("header");
        header.getChildren().addAll(infoJugadorLayout, labelTemporizador);

        VBox layoutPrincipal = new VBox();
        layoutPrincipal.setId("layoutPrincipal");
        layoutPrincipal.getChildren().addAll(header, preguntaLayout);

        Scene scene = new Scene(layoutPrincipal, 790, 550);
        File archivo = new File("src/main/resources/styles/style.css");
        scene.getStylesheets().add("file:///" + archivo.getAbsolutePath().replace("\\", "/")  );

        stage.setScene(scene);
    }
}
