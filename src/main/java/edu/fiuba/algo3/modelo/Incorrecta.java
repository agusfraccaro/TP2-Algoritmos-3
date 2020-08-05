package edu.fiuba.algo3.modelo;

public abstract class Incorrecta extends Opcion {

    public Incorrecta(String texto) {
        super(texto);
    }

    @Override
    int puntuar() {
        return 0;
    }

    boolean esCorrecta(){
        return false;
    }
}
