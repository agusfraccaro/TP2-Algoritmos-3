package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoiceParcial extends Pregunta {
    public MultipleChoiceParcial(List<Opcion> opciones, String texto) {
        super(opciones, texto);
    }

    @Override
    public void evaluarRespuestas(List<Respuesta> respuestas) {
        for(Respuesta respuesta: respuestas){
            if(respuesta.esCorrecta()){
                respuesta.sumarPuntos(puntuador.puntuar(respuesta));
            }
        }
    }
}
