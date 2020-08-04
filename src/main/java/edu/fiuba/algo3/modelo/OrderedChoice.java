package edu.fiuba.algo3.modelo;

import java.util.List;

public class OrderedChoice extends Pregunta {

    public OrderedChoice(List <Opcion> opciones, String texto) {
        super(opciones, texto);
    }

    /*
    @Override
    public void evaluarRespuestas(List<Respuesta> respuestas) {
        for(Respuesta respuesta : respuestas) {
            int puntos = 0;
            List<Opcion> opcionesMarcadas = respuesta.getOpciones();
            boolean estaEnOrden = true;
            for(int i = 0; i < opcionesMarcadas.size(); i++){
                if (!opcionesMarcadas.get(i).equalsTo(this.opciones.get(i))){estaEnOrden = false;};
            }
            if (estaEnOrden) {
                puntos = 1;
            }
            respuesta.sumarPuntos(puntos);
        }
    }*/

    @Override
    public int puntuar(Respuesta respuesta) {}

    @Override
    public void activarExclusividad(int factorExclusividad) {}
}
