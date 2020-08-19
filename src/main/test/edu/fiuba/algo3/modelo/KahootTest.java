package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.NoHaySiguientePreguntaExcepcion;
import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class KahootTest {

    @Test
    public void kahootRegistraUnJugadorCorrectamenteTest() {
        Kahoot kahoot = new Kahoot();
        kahoot.registrarJugador("cami");

        assertEquals(1, kahoot.getJugadores().size());
        assertEquals("cami", kahoot.getJugadores().get(0).getNombre());
    }

    @Test
    public void kahootDevuelveComoGanadorAlJugadorConMasPuntosTest(){
        Kahoot kahoot = new Kahoot();
        kahoot.registrarJugador("cami");
        kahoot.registrarJugador("agus");
        kahoot.getJugadores().get(0).sumarPuntos(5);
        kahoot.getJugadores().get(1).sumarPuntos(3);

        assertEquals("cami", kahoot.getGanador().getNombre());
    }

    @Test
    public void kahootDevuelveNullEnCasoDeEmpateTest(){
        Kahoot kahoot = new Kahoot();
        kahoot.registrarJugador("kevin");
        kahoot.registrarJugador("santi");
        kahoot.getJugadores().get(0).sumarPuntos(5);
        kahoot.getJugadores().get(1).sumarPuntos(5);

        assertEquals(null, kahoot.getGanador());
    }
}
