package edu.fiuba.algo3.modelo;

public abstract class Incorrecta implements EstadoOpcion {
    @Override
    public int puntuar() {
        return 0;
    }

    public boolean esCorrecta(){
        return false;
    }
}
