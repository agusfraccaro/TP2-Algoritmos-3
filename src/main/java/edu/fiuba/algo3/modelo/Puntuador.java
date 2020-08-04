package edu.fiuba.algo3.modelo;

import java.util.List;

public abstract class Puntuador {

    public abstract void puntuar(List<Respuesta> respuestas, Pregunta pregunta);

    public void corregirPreguntas(List<Respuesta> respuestas, Pregunta pregunta) {
        for (Respuesta respuesta : respuestas) {
            respuesta.sumarPuntos(pregunta.puntuar(respuesta));
        }
    }

    public void aplicarMultiplicadores(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.aplicarMultiplicador();
        }
    }

    public void aplicarPuntajes(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.aplicarPuntos();
        }
    }
}
