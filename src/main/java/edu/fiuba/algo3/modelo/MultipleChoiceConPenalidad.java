package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoiceConPenalidad extends Pregunta{

    public MultipleChoiceConPenalidad(List<Opcion> opciones, String texto) {
        super(opciones, texto);
    }

    /*
    @Override
    public void evaluarRespuestas(List<Respuesta> respuestas) {
        for(Respuesta respuesta: respuestas){
            respuesta.sumarPuntos(puntuador.puntuar(respuesta));
        }
    }*/

    @Override
    public int puntuar(Respuesta respuesta) {}

    @Override
    public void activarExclusividad(int factorExclusividad) {}
}
