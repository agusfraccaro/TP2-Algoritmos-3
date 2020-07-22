package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {
    @Test
    public void preguntaVerdaderoFalsoSeCreaConRespuestaCorrectaTest(){
        ArrayList <Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Correcta());
        opciones.add(new Incorrecta());
        Pregunta pregunta = new VerdaderoFalso(opciones);

        assertEquals(pregunta.cantidadRespuestasCorrectas(), 1);
    }

    @Test
    public void preguntaVerdaderoFalsoAsignaPuntosCorrectamenteSiEligeRespuestaCorrectaTest(){
        ArrayList <Opcion> opciones = new ArrayList<Opcion>();
        Opcion correcta = new Correcta();
        opciones.add(correcta);
        opciones.add(new Incorrecta());
        Pregunta pregunta = new VerdaderoFalso(opciones);
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        Jugador jugador = new Jugador("Cami");
        jugadores.add(jugador);
        jugadores.add(new Jugador("Kevin"));
        Ronda ronda = new Ronda(jugadores, pregunta);

        ronda.marcarOpcion(correcta);
        ronda.evaluar();

        assertEquals(jugador.getPuntaje(), 1);
    }

    @Test
    public void preguntaVerdaderoFalsoAsignaPuntosCorrectamenteSiEligeRespuestaIncorrectaTest(){
        ArrayList <Opcion> opciones = new ArrayList<Opcion>();
        Opcion incorrecta = new Incorrecta();
        opciones.add(incorrecta);
        opciones.add(new Correcta());
        Pregunta pregunta = new VerdaderoFalso(opciones);
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        Jugador jugador = new Jugador("Cami");
        jugadores.add(jugador);
        jugadores.add(new Jugador("Kevin"));
        Ronda ronda = new Ronda(jugadores, pregunta);

        ronda.marcarOpcion(incorrecta);
        ronda.evaluar();

        assertEquals(jugador.getPuntaje(), 0);
    }
}


