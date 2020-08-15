package edu.fiuba.algo3.vista;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;


public class Temporizador {

    private Integer inicio = 7;
    private Integer segundos = inicio;
    private Label label;
    private EventHandler<ActionEvent> eventoAlFinalizar;
    private Timeline timeline = new Timeline();

    public Temporizador(Label label, EventHandler<ActionEvent> controladorEnviarRespuesta){
        this.label = label;
        label.setText(segundos.toString());
        this.eventoAlFinalizar = controladorEnviarRespuesta;
    }

    public void correrTiempo(){
        timeline.setOnFinished(eventoAlFinalizar);
        timeline.setCycleCount(segundos+1);
        KeyFrame frame = new KeyFrame(Duration.seconds(1), actionEvent -> {
            segundos--;
            label.setText(segundos.toString());
        });
        timeline.getKeyFrames().add(frame);
        timeline.playFromStart();
    }

    public void stop(){
        timeline.stop();
    }
}
