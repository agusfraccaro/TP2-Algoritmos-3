package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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


}
