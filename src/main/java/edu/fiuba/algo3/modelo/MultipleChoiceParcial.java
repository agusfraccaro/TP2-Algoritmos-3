package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoiceParcial extends Pregunta {
    public MultipleChoiceParcial(List<Opcion> opciones, String texto) {
        super(opciones, texto);
    }

    @Override
    public int puntuar(Respuesta respuesta) {
        int puntos = 0;
        for (Opcion opcion : opciones) {
            if (!opcion.esCorrecta()) {
                return 0;
            }
            puntos += opcion.puntuar();
        }
        return puntos;
    }

    @Override
    public void activarExclusividad(int factorExclusividad) {
        this.puntuador = new PuntuadorExclusivo(factorExclusividad);
    }
}
