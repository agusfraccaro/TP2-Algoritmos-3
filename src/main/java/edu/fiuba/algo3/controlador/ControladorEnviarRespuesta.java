package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.vista.VistaPreguntas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ControladorEnviarRespuesta implements EventHandler<ActionEvent> {
    private Kahoot kahoot;
    private VistaPreguntas vista;
    private int cantidadRespuestas;
    private Stage stage;

    public ControladorEnviarRespuesta(Kahoot kahoot, VistaPreguntas vista, Stage stage, int cantidadRespuestas){
        this.kahoot = kahoot;
        this.cantidadRespuestas = cantidadRespuestas;
        this.vista = vista;
        this.stage = stage;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        List<Opcion> respuesta = new ArrayList<Opcion>();
        respuesta.add(kahoot.getPreguntaActual().getOpciones().get(0));
        //for(CheckBox radioButton : radioButtons) {
            //if (radioButton.isSelected())
            //respuesta.add();
        //}
        kahoot.enviarRespuesta(respuesta,1);

        if (cantidadRespuestas == 2) {
            kahoot.iniciarRonda();
            cantidadRespuestas = 0;
        }
        vista.mostrarPregunta();
    }
}
