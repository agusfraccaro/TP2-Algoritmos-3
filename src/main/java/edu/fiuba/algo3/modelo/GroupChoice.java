package edu.fiuba.algo3.modelo;

import java.util.List;

//FIXME Pensar la logica
public class GroupChoice extends Pregunta {

    public GroupChoice(List<Opcion> opciones, String texto) {
        super(opciones, texto);
    }

    @Override
    public int puntuar(Respuesta respuesta) {
        List<Opcion> opcionesMarcadas = respuesta.getOpciones();
        return 0;
    }

    @Override
    public void activarExclusividad(int factorExclusividad) {}
}
