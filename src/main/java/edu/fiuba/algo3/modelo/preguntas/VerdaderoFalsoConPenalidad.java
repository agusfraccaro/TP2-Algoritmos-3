package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.excepciones.NoMarcoOpcionExcepcion;
import edu.fiuba.algo3.modelo.preguntas.puntuador.Multiplicador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.preguntas.puntuador.Puntuador;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;

public class VerdaderoFalsoConPenalidad extends Pregunta {

    public VerdaderoFalsoConPenalidad(List<Opcion> opciones, String texto) {
        super(opciones, texto);
        this.puntuador = new Puntuador();
    }

    @Override
    public int puntuar(Respuesta respuesta) {
        int puntaje;

        try {
            puntaje = respuesta.getOpciones().get(0).puntuar();
        }
        catch(NoMarcoOpcionExcepcion ex) {
            puntaje=-1;
        }

        return puntaje;
    }

    @Override
    public void activarBonus(ArrayList<Integer> numeros) {
        this.puntuador.activarBonus(new Multiplicador(numeros));
    }
}
