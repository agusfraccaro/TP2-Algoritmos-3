package edu.fiuba.algo3.modelo;

public class Correcta extends Opcion {
    @Override
    public int puntuar() {
        return 1;
    }

    @Override
    boolean esCorrecta() {
        return true;
    }
}
