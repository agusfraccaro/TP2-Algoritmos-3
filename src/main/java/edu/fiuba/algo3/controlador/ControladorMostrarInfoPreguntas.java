package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.VistaInfoPreguntas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ControladorMostrarInfoPreguntas implements EventHandler<ActionEvent> {
    private Stage stagePrincipal;

    public ControladorMostrarInfoPreguntas (Stage stagePrincipal){
        this.stagePrincipal = stagePrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage infoPreguntas = new Stage();
        infoPreguntas.initOwner(stagePrincipal);
        infoPreguntas.setTitle("INFO PREGUNTAS");

        new VistaInfoPreguntas(infoPreguntas).mostrar();

        infoPreguntas.showAndWait();
    }
}
