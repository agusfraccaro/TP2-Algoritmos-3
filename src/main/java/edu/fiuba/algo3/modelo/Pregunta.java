package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface Pregunta {
    public int evaluarRespuestas(Respuesta respuesta);

    public int cantidadRespuestasCorrectas();
}
