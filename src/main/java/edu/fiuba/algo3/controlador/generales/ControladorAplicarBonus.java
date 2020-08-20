package edu.fiuba.algo3.controlador.generales;

import edu.fiuba.algo3.modelo.jugador.BONUS;
import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControladorAplicarBonus implements EventHandler<ActionEvent> {
    private final Kahoot kahoot;
    private final Button button;
    private final int extra;
    private final ControladorEnviarRespuesta controladorEnviarRespuesta;

    public ControladorAplicarBonus(Kahoot kahoot, Button button, int extra, ControladorEnviarRespuesta controladorEnviarRespuesta) {
        this.kahoot = kahoot;
        this.button = button;
        this.extra = extra;
        this.controladorEnviarRespuesta = controladorEnviarRespuesta;
    }

    @Override
    public void handle(ActionEvent actionEvent)
    {
        this.controladorEnviarRespuesta.setExtraPorBonus(extra);
        this.kahoot.gastarBonus((BONUS) button.getUserData());
    }
}
