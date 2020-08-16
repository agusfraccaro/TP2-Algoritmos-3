package edu.fiuba.algo3.modelo.preguntas.puntuador;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;

public class Multiplicador implements Bonus {
    private final List<Integer> factores;

    public Multiplicador(List<Integer> factores){
        this.factores = factores;
    }

    public void aplicarBonus(List<Respuesta> respuestas) {
        for (int i = 0; i < respuestas.size(); i++) {
            respuestas.get(i).multiplicarPuntos(factores.get(i));
        }
    }
}
