package edu.fiuba.algo3.modelo.opcion;


import edu.fiuba.algo3.modelo.opcion.EstadoOpcion;

public abstract class Incorrecta implements EstadoOpcion {
    @Override
    public abstract int puntuar();
    public boolean esCorrecta(){
        return false;
    }
}
