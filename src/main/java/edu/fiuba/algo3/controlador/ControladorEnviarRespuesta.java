package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.excepciones.NoHaySiguientePreguntaExcepcion;
import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.vista.VistaFinDelJuego;
import edu.fiuba.algo3.vista.VistaPreguntas;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ControladorEnviarRespuesta implements EventHandler<ActionEvent> {
    private boolean wasCalled = false;
    private final Kahoot kahoot;
    private final VistaPreguntas vista;
    private final int cantidadRespuestas;
    private final Stage stage;
    private final ObservableList<Node> buttons;
    private int extra;

    public ControladorEnviarRespuesta(Kahoot kahoot, VistaPreguntas vista, Stage stage, int cantidadRespuestas, ObservableList<Node> buttons){
        this.kahoot = kahoot;
        this.vista = vista;
        this.cantidadRespuestas = cantidadRespuestas;
        this.stage = stage;
        this.buttons = buttons;
    }

    public void setExtraPorBonus(int extra) {
        this.extra = extra;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.wasCalled) { return; }
        this.wasCalled = true;

        List<Opcion> selectedOptions = new ArrayList<>();
        for (Node node : buttons) {
            RadioButton button = (RadioButton) node;
            if (button.isSelected()) {
                selectedOptions.add((Opcion) button.getUserData());
            }
        }
        kahoot.enviarRespuesta(selectedOptions,extra);

        try {
            if (cantidadRespuestas == 2) {
                System.out.println("New Round");
                kahoot.iniciarRonda();
            }
            vista.mostrarPregunta();
        } catch (NoHaySiguientePreguntaExcepcion noHaySiguientePreguntaExcepcion) {
                new VistaFinDelJuego(kahoot, stage).mostrarResultado();
        }
    }
}
