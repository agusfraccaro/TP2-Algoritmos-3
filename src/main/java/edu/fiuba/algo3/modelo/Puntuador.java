package edu.fiuba.algo3.modelo;

import java.util.List;

public class Puntuador {
    public int puntuar(Respuesta respuesta) {
        int puntos = 0;
        for (Opcion opcion : respuesta.getOpciones()) {
            puntos += opcion.puntuar();
        }
        return puntos;
    }
}
