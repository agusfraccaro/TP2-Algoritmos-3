package edu.fiuba.algo3.vista;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;


public class Temporizador {

    private Integer inicio = 15;
    private Integer segundos = inicio;
    private Label label;

    public Temporizador(Label label){
        this.label = label;
        label.setText(segundos.toString());
    }

    public void correrTiempo(){
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame frame = new KeyFrame(Duration.seconds(1), actionEvent -> {
            label.setText(segundos.toString());
            segundos--;
            if (segundos < 0) {
                timeline.stop();
            }
        });
        timeline.getKeyFrames().add(frame);
        timeline.playFromStart();
    }
}
