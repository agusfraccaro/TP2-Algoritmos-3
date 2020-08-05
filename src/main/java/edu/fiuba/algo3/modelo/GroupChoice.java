package edu.fiuba.algo3.modelo;

import java.util.List;

public class GroupChoice extends Pregunta {

    public GroupChoice(List<Opcion> opciones, String texto) {
        super(opciones, texto);
    }

    @Override
    public int puntuar(Respuesta respuesta) {
        if((respuesta.getOpciones()).containsAll(this.opciones)){
            return 1;
        }
        return 0;
    }

    @Override
    public void activarExclusividad(int factorExclusividad) {
        this.puntuador = new PuntuadorExclusivo(factorExclusividad);
    }
}
