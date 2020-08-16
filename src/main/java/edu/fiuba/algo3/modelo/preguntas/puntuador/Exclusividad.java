package edu.fiuba.algo3.modelo.preguntas.puntuador;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;

public class Exclusividad implements Bonus {
    private final int factorExclusividad;

    public Exclusividad(List<Integer> numeros) {
        this.factorExclusividad = numeros.get(0) * numeros.get(1);
    }

    @Override
    public void aplicarBonus(List<Respuesta> respuestas) {
        Respuesta respuestaJugador1 = respuestas.get(0);
        Respuesta respuestaJugador2 = respuestas.get(1);
        if (respuestaJugador1.getPuntos() > respuestaJugador2.getPuntos()) {
            respuestaJugador1.multiplicarPuntos(factorExclusividad);
        } else if (respuestaJugador2.getPuntos() > respuestaJugador1.getPuntos()) {
            respuestaJugador2.multiplicarPuntos(factorExclusividad);
        }
    }
}
