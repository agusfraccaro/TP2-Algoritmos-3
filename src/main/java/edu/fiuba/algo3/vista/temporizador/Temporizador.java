package edu.fiuba.algo3.vista.temporizador;

import edu.fiuba.algo3.controlador.temporizador.ControladorTemporizador;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;


public class Temporizador {

    private final Integer inicio = 20;
    private Integer segundos = inicio;
    private final Label label;
    private final ControladorTemporizador controladorTemporizador;
    private Timeline timeline;

    public Temporizador(Label label, Button button){
        this.label = label;
        label.setText(segundos.toString());
        this.controladorTemporizador = new ControladorTemporizador(button);
    }

    public void correrTiempo(){
        timeline = new Timeline();
        timeline.setCycleCount(segundos+1);
        KeyFrame frame = new KeyFrame(Duration.seconds(1), actionEvent -> {
            segundos--;
            if (segundos < 0) {
                timeline.stop();
                controladorTemporizador.handle(new ActionEvent());
            }
            label.setText(segundos.toString());
        });
        timeline.getKeyFrames().add(frame);
        timeline.playFromStart();
    }


    public void stop(){
        timeline.stop();
    }
}
