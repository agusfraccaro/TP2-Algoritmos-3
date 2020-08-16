package edu.fiuba.algo3.modelo.opcion;

public class Correcta implements EstadoOpcion {
    @Override
    public int puntuar() {
        return 1;
    }

    @Override
    public boolean esCorrecta() {
        return true;
    }
}
