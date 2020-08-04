package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoiceParcial extends Pregunta {
    public MultipleChoiceParcial(List<Opcion> opciones, String texto) {
        super(opciones, texto);
    }

    @Override
    public int puntuar(Respuesta respuesta) {
        if (respuesta.todasLasOpcionesMarcadasSonCorrectas()) {
            return respuesta.getOpciones().size();
        }
        return 0;
    }

    @Override
    public void activarExclusividad(int factorExclusividad) {
        this.puntuador = new PuntuadorExclusivo(factorExclusividad);
    }
}
