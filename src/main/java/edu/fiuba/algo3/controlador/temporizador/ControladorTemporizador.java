package edu.fiuba.algo3.controlador.temporizador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControladorTemporizador implements EventHandler<ActionEvent> {

    private final Button button;

    public ControladorTemporizador(Button button) {
        this.button = button;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        button.fire();
    }
}
