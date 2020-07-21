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
        Jugador jugador = new Jugador("Cami");
        Respuesta respuesta = new Respuesta(jugador);

        respuesta.marcarOpcion(correcta);
        pregunta.evaluarRespuestas(respuesta);

        assertEquals(jugador.getPuntaje(), 1);
    }

    @Test
    public void preguntaVerdaderoFalsoAsignaPuntosCorrectamenteSiEligeRespuestaIncorrectaTest(){
        ArrayList <Opcion> opciones = new ArrayList<Opcion>();
        Opcion incorrecta = new Incorrecta();
        opciones.add(incorrecta);
        opciones.add(new Correcta());
        Pregunta pregunta = new VerdaderoFalso(opciones);
        Jugador jugador = new Jugador("Cami");
        Respuesta respuesta = new Respuesta(jugador);

        respuesta.marcarOpcion(incorrecta);
        pregunta.evaluarRespuestas(respuesta);

        assertEquals(jugador.getPuntaje(), 0);
    }
}


