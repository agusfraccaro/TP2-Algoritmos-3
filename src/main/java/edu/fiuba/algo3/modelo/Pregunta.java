package edu.fiuba.algo3.modelo;

import java.util.List;

public abstract class Pregunta {
    protected String texto;
    protected List<Opcion> opciones;
    protected Puntuador puntuador;

    public Pregunta(String texto) {
        this.texto = texto;
    }

    public abstract void evaluarRespuestas(List<Respuesta> respuestas);

    public abstract int cantidadRespuestasCorrectas();
}
