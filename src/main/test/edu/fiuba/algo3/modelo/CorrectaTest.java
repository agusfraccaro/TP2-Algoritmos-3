package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.opcion.Correcta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CorrectaTest {
    @Test
    public void correctaDevuelveUnPuntoTest(){
        Correcta correcta = new Correcta();
        assertEquals(1, correcta.puntuar());
    }

    @Test
    public void correctaDevuelveTrueAlPreguntarleSiEsCorrecta(){
        Correcta correcta = new Correcta();

        boolean esCorrecta = correcta.esCorrecta();
        assertTrue(esCorrecta);
    }
}
