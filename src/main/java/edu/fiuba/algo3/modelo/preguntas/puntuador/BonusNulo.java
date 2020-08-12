package edu.fiuba.algo3.modelo.preguntas.puntuador;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.List;

public class BonusNulo implements Bonus {

    @Override
    public void aplicarBonus(List<Respuesta> respuesta) {
        return;
    }
}
