package edu.fiuba.algo3.controlador.informacionJuego;

import edu.fiuba.algo3.vista.informacionJuego.VistaInfoBonus;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ControladorMostrarInfoBonus implements EventHandler<ActionEvent> {
    private Stage stagePrincipal;

    public ControladorMostrarInfoBonus (Stage stagePrincipal){
        this.stagePrincipal = stagePrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage infoBonus = new Stage();
        infoBonus.initOwner(stagePrincipal);
        infoBonus.setTitle("INFO BONUS");

        new VistaInfoBonus(infoBonus).mostrar();

        infoBonus.showAndWait();
    }
}