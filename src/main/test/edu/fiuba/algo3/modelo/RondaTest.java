package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RondaTest {
    @Test
    public void rondaEvaluaCorrectamenteRespuestasDeUnJugador(){
        List <Opcion> opciones = new ArrayList<Opcion>();
        Opcion correcta = new Correcta();
        opciones.add(correcta);
        opciones.add(new SinPenalidad());
        Pregunta pregunta = new VerdaderoFalso(opciones,"una pregunta");
        List<Jugador> jugadores = new ArrayList<Jugador>();
        Jugador jugador = new Jugador("Cami");
        jugadores.add(jugador);
        jugadores.add(new Jugador("Kevin"));

        Ronda ronda = new Ronda(jugadores, pregunta);
        //ronda.marcarOpcion(correcta);
        ronda.evaluar();

        assertEquals(jugador.getPuntaje(),1);
    }
    
    @Test
    public void rondaCambiaDeJugadorActualCorrectamente(){
        ArrayList <Opcion> opciones = new ArrayList<Opcion>();
        Opcion correcta = new Correcta();
        opciones.add(correcta);
        opciones.add(new SinPenalidad());
        Pregunta pregunta = new VerdaderoFalso(opciones,"una pregunta");
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        Jugador jugador1 = new Jugador("Cami");
        Jugador jugador2 = new Jugador("Kevin");
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Ronda ronda = new Ronda(jugadores, pregunta);

        assertEquals((ronda.getJugadorActual()).getNombre(), jugador2.getNombre());
    }
}

