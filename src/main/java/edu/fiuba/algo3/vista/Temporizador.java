package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;


public class Temporizador {

    private final Integer inicio = 7;
    private Integer segundos = inicio;
    private final Label label;
    private final ControladorTimer controladorTimer;
    private final Timeline timeline = new Timeline();

    public Temporizador(Label label, Button button){
        this.label = label;
        label.setText(segundos.toString());
        this.controladorTimer = new ControladorTimer(button);
    }

    public void correrTiempo(){
        timeline.setOnFinished(controladorTimer); //button.fire()
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
