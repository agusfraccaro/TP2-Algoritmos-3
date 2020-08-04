package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerdaderoFalso extends Pregunta {

    public VerdaderoFalso(List<Opcion> opciones, String texto) {
        super(opciones, texto);
    }

    /*
    @Override
    public void evaluarRespuestas(List<Respuesta> respuestas) {
        puntuador.puntuar(respuestas, this);

        for(Respuesta respuesta: respuestas){
            respuesta.sumarPuntos(puntuador.puntuar(respuesta));
        }
    }*/

    @Override
    public int puntuar(Respuesta respuesta) {
        return respuesta.getOpciones().get(0).puntuar();
    }

    @Override
    public void activarExclusividad(int factorExclusividad) {
        this.puntuador = new PuntuadorExclusivo(factorExclusividad);
    }

}
