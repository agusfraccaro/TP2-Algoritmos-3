package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class IncorrectaTest {
    @Test
    public void incorrectaSinPenalidadDevuelveCeroAlPuntuarTest(){
        Incorrecta opcion = new SinPenalidad();
        int puntos = opcion.puntuar();
        assertEquals(puntos, 0);
    }

    @Test
    public void incorrectaConPenalidadDevuelveUnoNegativoAlPuntuarTest(){
        Incorrecta opcion = new ConPenalidad();
        int puntos = opcion.puntuar();
        assertEquals(puntos, -1);
    }

    @Test
    public void incorrectaSinPenalidadDevuelveFalseAlPreguntarleSiEsCorrectaTest(){
        Incorrecta opcion = new SinPenalidad();
        boolean esCorrecta = opcion.esCorrecta();
        assertFalse(esCorrecta);
    }

    @Test
    public void incorrectaConPenalidadDevuelveFalseAlPreguntarleSiEsCorrectaTest(){
        Incorrecta opcion = new ConPenalidad();
        boolean esCorrecta = opcion.esCorrecta();
        assertFalse(esCorrecta);
    }
}
