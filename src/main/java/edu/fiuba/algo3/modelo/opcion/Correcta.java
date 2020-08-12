package edu.fiuba.algo3.modelo.opcion;


import edu.fiuba.algo3.modelo.opcion.EstadoOpcion;

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
