package edu.fiuba.algo3.controlador;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControladorTimer implements EventHandler<ActionEvent> {

    private final Button button;

    public ControladorTimer(Button button) {
        this.button = button;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        button.fire();
    }
}
