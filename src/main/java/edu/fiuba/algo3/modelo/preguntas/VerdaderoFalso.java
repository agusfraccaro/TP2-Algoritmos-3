package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.preguntas.puntuador.Exclusividad;
import edu.fiuba.algo3.modelo.preguntas.puntuador.Puntuador;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.List;

public class VerdaderoFalso extends Pregunta {

    public VerdaderoFalso(List<Opcion> opciones, String texto) {
        super(opciones, texto);
        this.puntuador = new Puntuador(new Exclusividad(new int[]{1,1}));
    }

    @Override
    public int puntuar(Respuesta respuesta) {
        return respuesta.getOpciones().get(0).puntuar();
    }

    @Override
    public void activarBonus(int[] numeros) {
        this.puntuador = new Puntuador(new Exclusividad(numeros));
    }

}