package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.excepciones.NoHaySiguientePreguntaExcepcion;
import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.preguntas.OrderedChoice;
import edu.fiuba.algo3.vista.VistaFinDelJuego;
import edu.fiuba.algo3.vista.VistaPreguntas;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ControladorEnviarRespuesta implements EventHandler<ActionEvent> {
    private boolean wasCalled = false;
    private final Kahoot kahoot;
    private final VistaPreguntas vista;
    private final int cantidadRespuestas;
    private final Stage stage;
    private final ObservableList<Node> botones;
    private int extra = 1;

    public ControladorEnviarRespuesta(Kahoot kahoot, VistaPreguntas vista, Stage stage, int cantidadRespuestas, ObservableList<Node> buttons){
        this.kahoot = kahoot;
        this.vista = vista;
        this.cantidadRespuestas = cantidadRespuestas;
        this.stage = stage;
        this.botones = buttons;
    }

    public void setExtraPorBonus(int extra) {
        this.extra = extra;
    }

    private void getOpcionesSeleccionadasOrderChoice(List<Opcion> opcionesSeleccionadas) {

        for(Opcion ignored : kahoot.getPreguntaActual().getOpciones()) {
            opcionesSeleccionadas.add(null);
        }
        for (Node nodo : botones) {
            TextField txtPosicion = (TextField) ((HBox)nodo).getChildren().get(1);
            if (!txtPosicion.getText().isEmpty()) {
                int posicion = Integer.parseInt(txtPosicion.getText()) - 1;
                opcionesSeleccionadas.set(posicion ,(Opcion)txtPosicion.getUserData() );
            }
        }
    }

    private void enviarRespuesta(List<Opcion> opcionesSeleccionadas)  {
        kahoot.enviarRespuesta(opcionesSeleccionadas,extra);
        try {
            if (cantidadRespuestas == 2) {
                kahoot.iniciarRonda();
            }
            vista.mostrarPregunta();
        } catch (NoHaySiguientePreguntaExcepcion noHaySiguientePreguntaExcepcion) {
            new VistaFinDelJuego(kahoot, stage).mostrarResultado();
        }
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.wasCalled) { return; }
        this.wasCalled = true;
        List<Opcion> opcionesSeleccionadas = new ArrayList<>(kahoot.getPreguntaActual().getOpciones().size());

        if (kahoot.getPreguntaActual() instanceof OrderedChoice){
            getOpcionesSeleccionadasOrderChoice(opcionesSeleccionadas);
        }
        else {
            for (Node nodo : botones) {
                RadioButton boton = (RadioButton) nodo;
                if (boton.isSelected()) {
                    opcionesSeleccionadas.add( (Opcion)boton.getUserData() );
                }
            }
        }

        enviarRespuesta(opcionesSeleccionadas);
    }
}
