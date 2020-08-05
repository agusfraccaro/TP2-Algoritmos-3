package edu.fiuba.algo3.modelo;

public class ConPenalidad extends Incorrecta{

    public ConPenalidad(String texto) {
        super(texto);
    }
    @Override
    public int puntuar() {
        return -1;
    }
}
