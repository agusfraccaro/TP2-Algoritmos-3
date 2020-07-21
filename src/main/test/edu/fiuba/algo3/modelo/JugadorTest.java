package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void jugadorSeCreaConCeroPuntosTest(){
        Jugador jugador = new Jugador("Agus");
        assertEquals(jugador.getPuntaje(), 0);
    }

    @Test
    public void jugadorSumaCorrectamenteCincoPuntosTest(){
        Jugador jugador = new Jugador("Santi");
        jugador.sumarPuntos(5);
        assertEquals(jugador.getPuntaje(), 5);
    }
}
