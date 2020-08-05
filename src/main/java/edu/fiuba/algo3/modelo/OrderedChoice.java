package edu.fiuba.algo3.modelo;

import java.util.List;

public class OrderedChoice extends Pregunta {

    public OrderedChoice(List <Opcion> opciones, String texto) {
        super(opciones, texto);
    }

    @Override
    public int puntuar(Respuesta respuesta) {
        if(opciones.equals(respuesta.getOpciones())){
            return 1;
        }
        return 0;
    }

    @Override
    public void activarExclusividad(int factorExclusividad) {
        this.puntuador = new PuntuadorExclusivo(factorExclusividad);
    }
}
