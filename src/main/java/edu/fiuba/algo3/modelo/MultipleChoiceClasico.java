package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoiceClasico extends Pregunta {

    public MultipleChoiceClasico(List <Opcion> opciones, String texto) {
        super(opciones, texto);
    }

    @Override
    public int puntuar(Respuesta respuesta) {
        //TODO Refactorizar a POO
        int cantCorrectas = 0;
        for (Opcion opcion : respuesta.getOpciones()) {
            if (!opcion.esCorrecta()) { return 0; }
            cantCorrectas += 1;
        }
        if (cantCorrectas == this.cantidadRespuestasCorrectas()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public void activarExclusividad(int factorExclusividad) {
        this.puntuador = new PuntuadorExclusivo(factorExclusividad);
    }
}
