package edu.fiuba.algo3.controlador.generales;

import edu.fiuba.algo3.modelo.excepciones.NoHaySiguientePreguntaExcepcion;
import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import edu.fiuba.algo3.vista.generales.VistaPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ControladorIniciarJuego implements EventHandler<ActionEvent> {

    private final Kahoot kahoot;
    private final Stage stage;

    public  ControladorIniciarJuego(Kahoot kahoot, Stage stage){
        this.kahoot = kahoot;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            kahoot.cargarPreguntas();
            kahoot.iniciarRonda();
        } catch (NoHaySiguientePreguntaExcepcion ignore) {
        }
        (new VistaPregunta(kahoot, stage)).mostrarPregunta();
    }
}
