package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Correcta;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.SinPenalidad;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import edu.fiuba.algo3.modelo.ronda.Ronda;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RondaTest {
    @Test
    public void rondaEvaluaCorrectamenteRespuestasDeUnJugador(){

        List <Opcion> opciones = new ArrayList<>();
        Opcion correcta = new Opcion("opcion1", new Correcta());
        opciones.add(correcta);
        opciones.add(new Opcion("opcion1", new SinPenalidad()));

        Pregunta pregunta = new VerdaderoFalso(opciones,"una pregunta");
        List<Jugador> jugadores = new ArrayList<>();
        Jugador jugador = new Jugador("Cami");
        jugadores.add(jugador);
        jugadores.add(new Jugador("Kevin"));

        List<Opcion> opcionesMarcadas = new ArrayList<>();
        opcionesMarcadas.add(correcta);

        Ronda ronda = new Ronda(jugadores, pregunta);
        ronda.enviarRespuesta(opcionesMarcadas, 1);
        ronda.enviarRespuesta(opcionesMarcadas, 1);

        assertEquals(1, jugador.getPuntaje());
    }
}

