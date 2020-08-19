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

        Opcion correcta = new Opcion("opcion1", new Correcta());
        List <Opcion> opciones = new ArrayList<>(){
            {add(correcta); add(new Opcion("opcion1", new SinPenalidad()));}
        };

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

    @Test
    public void rondaEstableceComoJugadorActualAlPrimeroEnLaListaTest(){
        List<Jugador> jugadores = new ArrayList<>(){
            {add(new Jugador("cami")); add(new Jugador("kevin"));}
        };
        List <Opcion> opciones = new ArrayList<>(){
            {add(new Opcion("opcion", new Correcta())); add(new Opcion("opcion1", new SinPenalidad()));}
        };

        Ronda ronda = new Ronda(jugadores, new VerdaderoFalso(opciones, "texto pregunta"));

        assertEquals("cami", ronda.getJugadorActual().getNombre());
    }

    @Test
    public void rondaCambiaDeJugadorActualCuandoSeEnviaLasRespuestasDelPrimerJugadorTest(){
        List<Jugador> jugadores = new ArrayList<>(){
            {add(new Jugador("cami")); add(new Jugador("kevin"));}
        };
        Opcion correcta = new Opcion("opcion1", new Correcta());
        List <Opcion> opciones = new ArrayList<>(){
            {add(correcta); add(new Opcion("opcion1", new SinPenalidad()));}
        };

        Ronda ronda = new Ronda(jugadores, new VerdaderoFalso(opciones, "texto pregunta"));
        List<Opcion> opcionesMarcadas = new ArrayList<>(){
            {add(correcta);}
        };

        ronda.enviarRespuesta(opcionesMarcadas, 1);

        assertEquals("kevin", ronda.getJugadorActual().getNombre());
    }
}

