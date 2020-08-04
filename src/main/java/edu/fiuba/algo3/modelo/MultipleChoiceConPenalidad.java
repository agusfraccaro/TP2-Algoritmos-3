package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoiceConPenalidad extends Pregunta{

    public MultipleChoiceConPenalidad(List<Opcion> opciones, String texto) {
        super(opciones, texto);
    }

    @Override
    public int puntuar(Respuesta respuesta) {
        int puntos = 0;
        for (Opcion opcion : respuesta.getOpciones()) {
            puntos += opcion.puntuar();
        }
        return puntos;
    }

    @Override
    public void activarExclusividad(int factorExclusividad) throws PreguntaSinExclusividadException {
        throw new PreguntaSinExclusividadException();
    }
}
