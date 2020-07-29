package edu.fiuba.algo3.modelo;

import java.util.List;

public abstract class Pregunta {
    protected String texto;
    protected List<Opcion> opciones;
    protected Puntuador puntuador;

    public Pregunta(List<Opcion> opciones, String texto) {
        this.texto = texto;
        this.opciones = opciones;
        puntuador = new Puntuador();
    }

    public abstract void evaluarRespuestas(List<Respuesta> respuestas);

    public int cantidadRespuestasCorrectas(){
        int puntos = 0;
        for(Opcion opcion: this.opciones){
            puntos = puntos + opcion.puntuar();
        }
        return puntos;
    }
}
