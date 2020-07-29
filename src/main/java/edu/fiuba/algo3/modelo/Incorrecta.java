package edu.fiuba.algo3.modelo;

public abstract class Incorrecta extends Opcion {
    @Override
    int puntuar() {
        return 0;
    }

    boolean esCorrecta(){
        return false;
    }
}
