package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoiceClasico extends Pregunta {

    public MultipleChoiceClasico(List <Opcion> opciones, String texto) {
        super(opciones, texto);
    }

    @Override
    public void evaluarRespuestas(List<Respuesta> respuestas) {
        for(Respuesta respuesta: respuestas){
            int puntos = puntuador.puntuar(respuesta);
            if(puntos == this.cantidadRespuestasCorrectas() && respuesta.todasLasOpcionesMarcadasSonCorrectas()){
                respuesta.sumarPuntos(1);
            }
        }
    }

}
