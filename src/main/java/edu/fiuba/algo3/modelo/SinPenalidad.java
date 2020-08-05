package edu.fiuba.algo3.modelo;

public class SinPenalidad extends Incorrecta {

    public SinPenalidad(String texto) {
        super(texto);
    }
    @Override
    int puntuar() {
        return super.puntuar();
    }
}
