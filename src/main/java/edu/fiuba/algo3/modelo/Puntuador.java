package edu.fiuba.algo3.modelo;

import java.util.List;

public class Puntuador {
    public void puntuar(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            int puntos = 0;
            for (Opcion opcion : respuesta.getOpciones()) {
                puntos += opcion.puntuar();
            }

            respuesta.sumarPuntos(respuesta.aplicarMultiplicador(puntos));
        }
    }
}
