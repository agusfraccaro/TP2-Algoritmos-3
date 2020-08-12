package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.opcion.Incorrecta;

public class SinPenalidad extends Incorrecta {
    @Override
    public int puntuar() {
        return 0;
    }
}
