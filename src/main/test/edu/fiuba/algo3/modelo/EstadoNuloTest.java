package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.EstadoNuloNoEsIncorrectoNiCorrectoExcepcion;
import edu.fiuba.algo3.modelo.excepciones.EstadoNuloNoPuntuaExcepcion;
import edu.fiuba.algo3.modelo.opcion.EstadoNulo;
import edu.fiuba.algo3.modelo.opcion.EstadoOpcion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EstadoNuloTest {
    @Test
    public void estadoNuloLanzaExcepcionCuandoSePuntuaTest(){
        EstadoOpcion estado = new EstadoNulo();
        boolean atrapada = false;
        try{
            estado.puntuar();
        }catch(EstadoNuloNoPuntuaExcepcion excepcion){
            atrapada = true;
        }

        assertTrue(atrapada);
    }

    @Test
    public void estadoNuloLanzaExcepcionCuandoSeLePreguntaSiEsCorrectaTest(){
        EstadoOpcion estado = new EstadoNulo();
        boolean atrapada = false;
        try{
            estado.esCorrecta();
        }catch(EstadoNuloNoEsIncorrectoNiCorrectoExcepcion excepcion){
            atrapada = true;
        }

        assertTrue(atrapada);
    }
}
