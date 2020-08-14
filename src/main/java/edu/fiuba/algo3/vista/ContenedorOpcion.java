package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import javafx.scene.control.RadioButton;

public class ContenedorOpcion {
    private Opcion opcion;
    private RadioButton boton;

    public ContenedorOpcion(Opcion opcion){
        this.opcion = opcion;
        this.boton = new RadioButton(opcion.getTexto());
    }

    public RadioButton getBoton(){
        return boton;
    }

    public Opcion getOpcionSeleccionada(){
        if(boton.isSelected()){
            return this.opcion;
        }
        return null;
    }

}
