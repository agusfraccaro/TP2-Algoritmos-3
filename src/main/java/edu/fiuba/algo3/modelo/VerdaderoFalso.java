package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoFalso implements Pregunta {

    private ArrayList<Opcion> opciones;

    public VerdaderoFalso(ArrayList<Opcion> opciones){
        this.opciones = opciones;
    }

    @Override
    public int evaluarRespuestas(Respuesta respuesta) {
        int puntos = 0;
        ArrayList<Opcion> listaOpciones = respuesta.getOpciones();
        for(Opcion opcion: listaOpciones){
            puntos = puntos + opcion.puntuar();
        }
        return puntos;
    }

    @Override
    public int cantidadRespuestasCorrectas() {
        int puntos = 0;
        for(Opcion opcion: this.opciones){
            puntos = puntos + opcion.puntuar();
        }
        return puntos;
    }
}