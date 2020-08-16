package edu.fiuba.algo3.modelo.opcion;

public class ConPenalidad extends Incorrecta {
    @Override
    public int puntuar() {
        return -1;
    }
}
