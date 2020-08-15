package edu.fiuba.algo3.vista;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;


public class Temporizador {

    private Integer inicio = 3;
    private Integer segundos = inicio;
    private Label label;
    private EventHandler<ActionEvent> eventoAlFinalizar;

    public Temporizador(Label label, EventHandler<ActionEvent> controladorEnviarRespuesta){
        this.label = label;
        label.setText(segundos.toString());
        this.eventoAlFinalizar = controladorEnviarRespuesta;
    }

    public void correrTiempo(){
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame frame = new KeyFrame(Duration.seconds(1), actionEvent -> {
            label.setText(segundos.toString());
            segundos--;
            if (segundos < -1) {
                timeline.stop();
                eventoAlFinalizar.handle(new ActionEvent());
            }
        });
        timeline.getKeyFrames().add(frame);
        timeline.playFromStart();
    }
}
