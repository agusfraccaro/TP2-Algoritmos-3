package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.BONUS;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {

    @Test
    public void jugadorSeCreaConCeroPuntosTest(){
        Jugador jugador = new Jugador("Agus");
        assertEquals(0, jugador.getPuntaje());
    }

    @Test
    public void jugadorSumaCorrectamenteCincoPuntosTest(){
        Jugador jugador = new Jugador("Santi");
        jugador.sumarPuntos(5);
        assertEquals(5, jugador.getPuntaje());
    }

    @Test
    public void jugadorDevuelveCorrectamenteSuNombreTest(){
        Jugador jugador = new Jugador("Kevin");
        String nombre = jugador.getNombre();
        assertEquals("Kevin", nombre);
    }

    @Test
    public void jugadorPuedeAplicarTodosLosBonusAlSinHaberGastadoNingunoTest(){
        Jugador jugador = new Jugador("cami");

        assertTrue(jugador.puedeAplicarExclusividad());
        assertTrue(jugador.puedeAplicarMultiplicadorPor2());
        assertTrue(jugador.puedeAplicarMultiplicadorPor3());
    }

    @Test
    public void jugadorNoPuedeVolverAUsarMultiplicadorLuegoDeQueLoGastoTest(){
        Jugador jugador = new Jugador("agus");
        jugador.gastarBonus(BONUS.X2);
        jugador.gastarBonus(BONUS.X3);

        assertFalse(jugador.puedeAplicarMultiplicadorPor2());
        assertFalse(jugador.puedeAplicarMultiplicadorPor3());
    }

    @Test
    public void jugadorPuedeVolverAUsarExclusividadLuegoDeQueLoGastoUnaVezTest(){
        Jugador jugador = new Jugador("agus");
        jugador.gastarBonus(BONUS.EXCLUSIVIDAD);

        assertTrue(jugador.puedeAplicarExclusividad());
    }

    @Test
    public void jugadorNoPuedeVolverAUsarExclusividadLuegoDeQueLoGastoDosVecesTest(){
        Jugador jugador = new Jugador("agus");
        jugador.gastarBonus(BONUS.EXCLUSIVIDAD);
        jugador.gastarBonus(BONUS.EXCLUSIVIDAD);

        assertFalse(jugador.puedeAplicarExclusividad());
    }
}
