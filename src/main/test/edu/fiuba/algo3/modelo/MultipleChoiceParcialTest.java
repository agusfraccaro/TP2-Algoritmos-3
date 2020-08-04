package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceParcialTest {
    @Test
    public void preguntaMultipleChoiceParcialSeCreaConOpcionesCorrectasTest(){
        List <Opcion> opciones = new ArrayList<Opcion>();
        Opcion correcta1 = new Correcta();
        Opcion correcta2 = new Correcta();
        Opcion correcta3 = new Correcta();
        opciones.add(correcta1);
        opciones.add(correcta2);
        opciones.add(correcta3);
        opciones.add(new SinPenalidad());
        Pregunta pregunta = new MultipleChoiceParcial(opciones, "una pregunta");

        assertEquals(3, pregunta.cantidadRespuestasCorrectas());
    }

    @Test
    public void preguntaMultipleChoiceParcialPuntuaAJugadoresCorrectamenteSiNingunoDeLosJugadoresEligeOpcionIncorrecta(){
        List <Opcion> opciones = new ArrayList<Opcion>();
        Opcion correcta1 = new Correcta();
        Opcion correcta2 = new Correcta();
        Opcion correcta3 = new Correcta();
        Opcion incorrecta = new SinPenalidad();
        opciones.add(correcta1);
        opciones.add(correcta2);
        opciones.add(correcta3);
        opciones.add(incorrecta);

        Pregunta pregunta = new MultipleChoiceParcial(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Agus");
        Jugador jugador2 = new Jugador("Santi");
        List <Opcion> opcionesMarcadas1 = new ArrayList<Opcion>();
        List <Opcion> opcionesMarcadas2 = new ArrayList<Opcion>();
        opcionesMarcadas1.add(correcta1);
        opcionesMarcadas1.add(correcta2);
        opcionesMarcadas2.add(correcta3);

        List <Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1, new Multiplicador(1)));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2, new Multiplicador(1)));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(2, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }

    @Test
    public void preguntaMultipleChoiceParcialPuntuaAJugadoresCorrectamenteSiAmbosEligenAlMenosUnaOpcionIncorrecta(){
        List <Opcion> opciones = new ArrayList<Opcion>();
        Opcion correcta1 = new Correcta();
        Opcion correcta2 = new Correcta();
        Opcion incorrecta = new SinPenalidad();
        opciones.add(correcta1);
        opciones.add(correcta2);
        opciones.add(incorrecta);

        Pregunta pregunta = new MultipleChoiceParcial(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Agus");
        Jugador jugador2 = new Jugador("Santi");
        List <Opcion> opcionesMarcadas1 = new ArrayList<Opcion>();
        List <Opcion> opcionesMarcadas2 = new ArrayList<Opcion>();
        opcionesMarcadas1.add(correcta1);
        opcionesMarcadas1.add(incorrecta);
        opcionesMarcadas2.add(incorrecta);
        opcionesMarcadas2.add(correcta2);
        opcionesMarcadas2.add(correcta1);

        List <Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1, new Multiplicador(1)));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2, new Multiplicador(1)));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }
}
