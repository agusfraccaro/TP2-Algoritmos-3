package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class IncorrectaTest {
    @Test
    public void incorrectaSinPenalidadDevuelveCeroAlPuntuarTest(){
        Incorrecta opcion = new SinPenalidad("A");
        int puntos = opcion.puntuar();
        assertEquals(0, puntos);
    }

    @Test
    public void incorrectaConPenalidadDevuelveUnoNegativoAlPuntuarTest(){
        Incorrecta opcion = new ConPenalidad("A");
        int puntos = opcion.puntuar();
        assertEquals(-1, puntos);
    }

    @Test
    public void incorrectaSinPenalidadDevuelveFalseAlPreguntarleSiEsCorrectaTest(){
        Incorrecta opcion = new SinPenalidad("A");
        boolean esCorrecta = opcion.esCorrecta();
        assertFalse(esCorrecta);
    }

    @Test
    public void incorrectaConPenalidadDevuelveFalseAlPreguntarleSiEsCorrectaTest(){
        Incorrecta opcion = new ConPenalidad("A");
        boolean esCorrecta = opcion.esCorrecta();
        assertFalse(esCorrecta);
    }
}
