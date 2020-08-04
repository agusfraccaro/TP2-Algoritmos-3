package edu.fiuba.algo3.modelo;

import java.util.List;

public abstract class Puntuador {
    //Una pequeña idea...
    //private Bonus bonus = new BonusNulo();

    public abstract void puntuar(List<Respuesta> respuestas, Pregunta pregunta);
    //Si usamos bonus...
    /*{
        corregirPreguntas(respuestas, pregunta);
        aplicarBonus(respuestas);
        aplicarPuntajes(respuestas);
    }*/

    public void corregirPreguntas(List<Respuesta> respuestas, Pregunta pregunta) {
        for (Respuesta respuesta : respuestas) {
            respuesta.sumarPuntos(pregunta.puntuar(respuesta));
        }
    }
    /*
    public void aplicarBonus(List<Respuesta> respuestas) {
        this.bonus.aplicarBonus(respuestas);
    }*/

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
