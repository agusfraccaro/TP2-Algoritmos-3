package edu.fiuba.algo3.modelo.preguntas.puntuador;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.List;

public class Puntuador {
    private Bonus bonus;

    public Puntuador() {
        this.bonus = new BonusNulo();
    }

    public void activarBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    public Bonus getBonus(){
        return this.bonus;
    }

    public void puntuar(List<Respuesta> respuestas, Pregunta pregunta) {
        corregirPreguntas(respuestas, pregunta);
        aplicarBonus(respuestas);
        aplicarPuntajes(respuestas);
    }

    public void corregirPreguntas(List<Respuesta> respuestas, Pregunta pregunta) {
        for (Respuesta respuesta : respuestas) {
            respuesta.sumarPuntos(pregunta.puntuar(respuesta));
        }
    }

    public void aplicarBonus(List<Respuesta> respuestas) {
        this.bonus.aplicarBonus(respuestas);
    }

    public void aplicarPuntajes(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.aplicarPuntos();
        }
    }
}
