package edu.fiuba.algo3.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonResponder extends Button {

    /*public BotonResponder(Kahoot kahoot, VistaPreguntas vista, Stage stage, int cantidadRespuestas, List<ContenedorOpcion> botones){
        super();
        this.setText("Responder");
        this.setOnAction(new ControladorEnviarRespuesta(kahoot, vista, stage, cantidadRespuestas, botones));
    }*/

    public BotonResponder(EventHandler<ActionEvent> controladorEnviarRespuesta){
        super();
        this.setText("Responder");
        this.setOnAction(controladorEnviarRespuesta);
    }
}
