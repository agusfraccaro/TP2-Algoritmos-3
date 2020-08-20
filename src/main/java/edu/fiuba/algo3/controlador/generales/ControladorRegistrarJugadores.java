package edu.fiuba.algo3.controlador.generales;

import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import edu.fiuba.algo3.vista.generales.VistaInicioJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorRegistrarJugadores implements EventHandler<ActionEvent> {
    private final Kahoot kahoot;
    private final Stage stage;
    private final TextField jugador1;
    private final TextField jugador2;

    public ControladorRegistrarJugadores(Kahoot kahoot, Stage stage, TextField jugador1, TextField jugador2){
        this.kahoot = kahoot;
        this.stage = stage;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }
    private void registrarJugadores(TextField jugador1,TextField jugador2) {
        kahoot.registrarJugador(jugador1.getText());
        kahoot.registrarJugador(jugador2.getText());
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (jugador1.getText().length() > 0 && jugador2.getText().length() > 0){
            registrarJugadores(jugador1,jugador2);
            (new VistaInicioJuego(kahoot, stage)).mostrarInicio();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.NONE,
                    "Debe ingresar los nombres de ambos jugadores", ButtonType.OK);
            alert.show();
        }
    }
}
