package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RondaTest {
    @Test
    public void rondaEvaluaCorrectamenteRespuestasDeUnJugador(){
        List <Opcion> opciones = new ArrayList<>();
        Opcion correcta = new Correcta("A");
        opciones.add(correcta);
        opciones.add(new SinPenalidad("B"));
        Pregunta pregunta = new VerdaderoFalso(opciones,"una pregunta");
        List<Jugador> jugadores = new ArrayList<>();
        Jugador jugador = new Jugador("Cami");
        jugadores.add(jugador);
        jugadores.add(new Jugador("Kevin"));

        List<Opcion> opcionesMarcadas = new ArrayList<>();
        opcionesMarcadas.add(correcta);

        Ronda ronda = new Ronda(jugadores, pregunta);
        ronda.enviarRespuesta(opcionesMarcadas, 1);
        ronda.siguienteJugador();
        ronda.enviarRespuesta(opcionesMarcadas, 1);
        ronda.evaluar();

        assertEquals(1, jugador.getPuntaje());
    }
    

}

