package edu.fiuba.algo3.controlador;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class ControladorTextoNumerico implements ChangeListener<String>{

    private TextField txtNumeroOpcion;
    private int cantidadOpciones;

    public ControladorTextoNumerico(TextField txtNumeroOpcion, int cantidadOpciones){
        this.txtNumeroOpcion = txtNumeroOpcion;
        this.cantidadOpciones = cantidadOpciones;
    }

    @Override
    public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
        if (!newValue.matches("[0-9]*")) {
            txtNumeroOpcion.setText(newValue.replaceAll("[^\\d]", ""));
        }

        if( newValue.length() > 1){
            txtNumeroOpcion.setText(newValue.substring(0,1));
        }

        if(Integer.parseInt(newValue) > cantidadOpciones){
            txtNumeroOpcion.setText("");
        }
    }
}
