package edu.fiuba.algo3.modelo;

public class Correcta extends Opcion {

    public Correcta(String texto) {
        super(texto);
    }
    @Override
    public int puntuar() {
        return 1;
    }

    @Override
    boolean esCorrecta() {
        return true;
    }
}
