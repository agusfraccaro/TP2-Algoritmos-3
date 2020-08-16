package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.excepciones.NoMarcoOpcionExcepcion;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.preguntas.puntuador.Multiplicador;
import edu.fiuba.algo3.modelo.preguntas.puntuador.Puntuador;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.List;

public class MultipleChoiceConPenalidad extends Pregunta {

    public MultipleChoiceConPenalidad(List<Opcion> opciones, String texto) {
        super(opciones, texto);
        this.puntuador = new Puntuador();
    }

    @Override
    public int puntuar(Respuesta respuesta) {
        int puntos = 0;

        try {
            List<Opcion> opciones = respuesta.getOpciones();
            for (Opcion opcion : opciones) {
                puntos += opcion.puntuar();
            }
            return puntos;
        }

        catch(NoMarcoOpcionExcepcion ex) {
            return puntos;
        }
    }

    @Override
    public void activarBonus(List<Integer> numeros) {
        this.puntuador.activarBonus(new Multiplicador(numeros));
    }
}
