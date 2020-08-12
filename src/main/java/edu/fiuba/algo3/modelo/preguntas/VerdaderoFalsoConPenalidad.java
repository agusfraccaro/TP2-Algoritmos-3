package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerdaderoFalsoConPenalidad extends Pregunta {

    public VerdaderoFalsoConPenalidad(List<Opcion> opciones, String texto) {
        super(opciones, texto);
        this.puntuador = new Puntuador(new Multiplicador(new int[]{1,1}));
    }

    @Override
    public int puntuar(Respuesta respuesta) {
        return respuesta.getOpciones().get(0).puntuar();
    }

    @Override
    public void activarBonus(int[] numeros) {
        this.puntuador = new Puntuador(new Multiplicador(numeros));
    }
}
