package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CorrectaTest {
    @Test
    public void correctaDevuelveUnPuntoTest(){
        Opcion correcta = new Correcta();

        assertEquals(1, correcta.puntuar());
    }

    @Test
    public void correctaDevuelveTrueAlPreguntarleSiEsCorrecta(){
        Opcion correcta = new Correcta();
        boolean esCorrecta = correcta.esCorrecta();
        assertTrue(esCorrecta);
    }

}
