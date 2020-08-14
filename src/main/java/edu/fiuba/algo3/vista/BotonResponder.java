package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorEnviarRespuesta;
import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.List;

public class BotonResponder extends Button {

    public BotonResponder(Kahoot kahoot, VistaPreguntas vista, Stage stage, int cantidadRespuestas, List<ContenedorOpcion> botones){
        super();
        this.setText("Responder");
        this.setOnAction(new ControladorEnviarRespuesta(kahoot, vista, stage, cantidadRespuestas, botones));
    }
}
