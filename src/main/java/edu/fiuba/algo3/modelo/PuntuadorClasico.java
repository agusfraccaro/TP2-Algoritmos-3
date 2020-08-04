package edu.fiuba.algo3.modelo;

import java.util.List;

public class PuntuadorClasico extends Puntuador {

    @Override
    public void puntuar(List<Respuesta> respuestas, Pregunta pregunta) {
        corregirPreguntas(respuestas, pregunta);
        aplicarMultiplicadores(respuestas);
        aplicarPuntajes(respuestas);
    }

}
