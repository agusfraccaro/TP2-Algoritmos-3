package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RondaTest {
    @Test
    public void rondaEvaluaCorrectamenteRespuestasDeUnJugador(){
        List <Opcion> opciones = new ArrayList<Opcion>();
        Opcion correcta = new Opcion("opcion1", new Correcta());
        opciones.add(correcta);
        opciones.add(new Opcion("opcion1", new SinPenalidad()));
        Pregunta pregunta = new VerdaderoFalso(opciones,"una pregunta");
        List<Jugador> jugadores = new ArrayList<Jugador>();
        Jugador jugador = new Jugador("Cami");
        jugadores.add(jugador);
        jugadores.add(new Jugador("Kevin"));

        List<Opcion> opcionesMarcadas = new ArrayList<Opcion>();
        opcionesMarcadas.add(correcta);

        Ronda ronda = new Ronda(jugadores, pregunta);
        ronda.enviarRespuesta(opcionesMarcadas, new Multiplicador(1));
        ronda.evaluar();

        assertEquals(1, jugador.getPuntaje());
    }
    

}

