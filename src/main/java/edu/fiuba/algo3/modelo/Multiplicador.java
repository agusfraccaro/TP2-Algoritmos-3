package edu.fiuba.algo3.modelo;

import java.util.List;

public class Multiplicador {
    private int cantidadAMultiplicar;

    public Multiplicador(int cantidadAMultiplicar){
        this.cantidadAMultiplicar = cantidadAMultiplicar;
    }

    public int multiplicar(int puntos) {
        return cantidadAMultiplicar * puntos;
    }
}
