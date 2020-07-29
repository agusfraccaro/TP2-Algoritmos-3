package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerdaderoFalso extends Pregunta {

    public VerdaderoFalso(List<Opcion> opciones, String texto) {
        super(opciones, texto);
    }

    @Override
    public void evaluarRespuestas(List<Respuesta> respuestas) {
        for(Respuesta respuesta: respuestas){
            respuesta.sumarPuntos(puntuador.puntuar(respuesta));
        }
    }

    @Override
    public int cantidadRespuestasCorrectas() {
        int puntos = 0;
        for(Opcion opcion: this.opciones){
            puntos = puntos + opcion.puntuar();
        }
        return puntos;
    }
}
