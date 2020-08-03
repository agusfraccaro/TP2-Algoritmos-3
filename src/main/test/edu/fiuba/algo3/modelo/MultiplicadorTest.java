package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicadorTest {

    @Test
    public void multiplicadorMultiplicaCorrectamente(){
        Multiplicador mult = new Multiplicador(2);
        int producto = mult.multiplicar(69);

        assertEquals(producto, 138);
    }
}
