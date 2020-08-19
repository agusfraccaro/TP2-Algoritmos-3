package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.opcion.ConPenalidad;
import edu.fiuba.algo3.modelo.opcion.Incorrecta;
import edu.fiuba.algo3.modelo.opcion.SinPenalidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class IncorrectaTest {
    @Test
    public void incorrectaSinPenalidadDevuelveCeroAlPuntuarTest(){
        Incorrecta opcion = new SinPenalidad();
        int puntos = opcion.puntuar();
        assertEquals(0, puntos);
    }

    @Test
    public void incorrectaConPenalidadDevuelveUnoNegativoAlPuntuarTest(){
        Incorrecta opcion = new ConPenalidad();
        int puntos = opcion.puntuar();
        assertEquals(-1, puntos);
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
