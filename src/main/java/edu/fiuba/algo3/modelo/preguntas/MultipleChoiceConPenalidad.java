package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.preguntas.puntuador.Multiplicador;
import edu.fiuba.algo3.modelo.preguntas.puntuador.Puntuador;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.List;

public class MultipleChoiceConPenalidad extends Pregunta {

    public MultipleChoiceConPenalidad(List<Opcion> opciones, String texto) {
        super(opciones, texto);
        this.puntuador = new Puntuador(new Multiplicador(new int[]{1,1}));
    }

    @Override
    public int puntuar(Respuesta respuesta) {
        int puntos = 0;
        for (Opcion opcion : respuesta.getOpciones()) {
            puntos += opcion.puntuar();
        }
        return puntos;
    }

    @Override
    public void activarBonus(int[] numeros) {
        this.puntuador = new Puntuador(new Multiplicador(numeros));
    }
}
