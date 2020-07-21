package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CorrectaTest {
    @Test
    public void correctaDevuelveUnPuntoTest(){
        Opcion correcta = new Correcta();

        assertEquals(correcta.puntuar(), 1);
    }
}
