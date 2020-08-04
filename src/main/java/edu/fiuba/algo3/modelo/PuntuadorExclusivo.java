package edu.fiuba.algo3.modelo;

import java.util.List;

public class PuntuadorExclusivo extends Puntuador {
    //TODO Preguntar si rompe Liskov
    private final int factorExclusividad;

    public PuntuadorExclusivo(int factorExclusividad) {
        this.factorExclusividad = factorExclusividad;
    }

    @Override
    public void puntuar(List<Respuesta> respuestas, Pregunta pregunta) {
        corregirPreguntas(respuestas, pregunta);
        aplicarExclusividad(respuestas);
        aplicarPuntajes(respuestas);
    }

    public void aplicarExclusividad(List<Respuesta> respuestas) {
        boolean exclusiva = respuestas.get(0).esCorrecta() ^ respuestas.get(1).esCorrecta(); //esCorrecta1 XOR esCorrecta2
        if (exclusiva) {
            for (Respuesta respuesta : respuestas) {
                if (respuesta.esCorrecta()) {
                    respuesta.aplicarExclusividad(factorExclusividad);
                }
            }
        }
    }
}
