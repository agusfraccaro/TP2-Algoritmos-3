package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorAplicarBonus implements EventHandler<ActionEvent> {
    private final int extra;
    private final ControladorEnviarRespuesta controladorEnviarRespuesta;

    public ControladorAplicarBonus(int extra, ControladorEnviarRespuesta controladorEnviarRespuesta) {
        this.extra = extra;
        this.controladorEnviarRespuesta = controladorEnviarRespuesta;
    }

    @Override
    public void handle(ActionEvent actionEvent)
    {
        this.controladorEnviarRespuesta.setExtraPorBonus(extra);
    }
}