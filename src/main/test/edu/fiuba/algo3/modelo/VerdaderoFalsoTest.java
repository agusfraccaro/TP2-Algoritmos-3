package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {
    @Test
    public void preguntaVerdaderoFalsoSeCreaConRespuestaCorrectaTest(){
        ArrayList <Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Correcta());
        opciones.add(new SinPenalidad());
        Pregunta pregunta = new VerdaderoFalso(opciones,"una pregunta");

        assertEquals(1, pregunta.cantidadRespuestasCorrectas());
    }

    @Test
    public void preguntaVerdaderoFalsoAsignaUnPuntoSiEligenRespuestaCorrectaTest(){
        List <Opcion> opciones = new ArrayList<Opcion>();
        Opcion correcta = new Correcta();
        opciones.add(correcta);
        opciones.add(new SinPenalidad());
        Pregunta pregunta = new VerdaderoFalso(opciones,"una pregunta");
        Jugador jugador1 = new Jugador("Cami");
        Jugador jugador2 = new Jugador("Kevin");
        List <Opcion> opcionesMarcadas1 = new ArrayList<Opcion>();
        List <Opcion> opcionesMarcadas2 = new ArrayList<Opcion>();
        opcionesMarcadas1.add(correcta);
        opcionesMarcadas2.add(correcta);
        List <Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1, new Multiplicador(1)));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2, new Multiplicador(1)));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }

    @Test
    public void preguntaVerdaderoFalsoNoAsignaPuntosSiEligenRespuestaIncorrectaTest(){
        List <Opcion> opciones = new ArrayList<Opcion>();
        Opcion incorrecta = new SinPenalidad();
        opciones.add(incorrecta);
        opciones.add(new Correcta());
        Pregunta pregunta = new VerdaderoFalso(opciones,"una pregunta");
        Jugador jugador1 = new Jugador("Cami");
        Jugador jugador2 = new Jugador("Kevin");
        List <Opcion> opcionesMarcadas1 = new ArrayList<Opcion>();
        List <Opcion> opcionesMarcadas2 = new ArrayList<Opcion>();
        opcionesMarcadas1.add(incorrecta);
        opcionesMarcadas2.add(incorrecta);
        List <Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1, new Multiplicador(1)));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2, new Multiplicador(1)));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }

    @Test
    public void preguntaVerdaderoFalsoConPenalidadRestaPuntosSiSeEligeRespuestaIncorrectaTest(){
        Opcion correcta = new Correcta();
        Opcion incorrecta = new ConPenalidad();
        List <Opcion> opciones = new ArrayList<Opcion>(){
            {add(correcta); add(incorrecta);}
        };
        Pregunta pregunta = new VerdaderoFalso(opciones, "una pregunta");
        Jugador jugador1 = new Jugador("Cami");
        Jugador jugador2 = new Jugador("Kevin");
        List <Opcion> opcionesMarcadas1 = new ArrayList<Opcion>();
        List <Opcion> opcionesMarcadas2 = new ArrayList<Opcion>();
        opcionesMarcadas1.add(incorrecta);
        opcionesMarcadas2.add(incorrecta);
        List <Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1, new Multiplicador(1)));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2, new Multiplicador(1)));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(-1, jugador1.getPuntaje());
        assertEquals(-1, jugador2.getPuntaje());

    }
}


