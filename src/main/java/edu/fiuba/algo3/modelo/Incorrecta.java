package edu.fiuba.algo3.modelo;

public abstract class Incorrecta implements EstadoOpcion {
    @Override
    public abstract int puntuar();
    public boolean esCorrecta(){
        return false;
    }
}
