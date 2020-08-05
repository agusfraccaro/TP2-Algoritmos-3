package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceParcialTest {
    @Test
    public void preguntaMultipleChoiceParcialSeCreaConOpcionesCorrectasTest(){
        Opcion correcta1 = new Opcion("opcion1", new Correcta());
        Opcion correcta2 = new Opcion("opcion2", new Correcta());
        Opcion correcta3 = new Opcion("opcion3", new Correcta());
        List <Opcion> opciones = new ArrayList<Opcion>(){
            {add(correcta1); add(correcta2); add(correcta3); add(new Opcion("opcion4", new SinPenalidad()));};
        };

        Pregunta pregunta = new MultipleChoiceParcial(opciones, "una pregunta");

        assertEquals(3, pregunta.cantidadRespuestasCorrectas());
    }

    @Test
    public void preguntaMultipleChoiceParcialPuntuaAJugadoresCorrectamenteSiNingunoDeLosJugadoresEligeOpcionIncorrecta(){
        Opcion correcta1 = new Opcion("opcion1", new Correcta());
        Opcion correcta2 = new Opcion("opcion2", new Correcta());
        Opcion correcta3 = new Opcion("opcion3", new Correcta());
        Opcion incorrecta = new Opcion("opcion4", new SinPenalidad());
        List <Opcion> opciones = new ArrayList<Opcion>(){
            {add(correcta1); add(correcta2); add(correcta3); add(incorrecta);};
        };

        Pregunta pregunta = new MultipleChoiceParcial(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Agus");
        Jugador jugador2 = new Jugador("Santi");

        List <Opcion> opcionesMarcadas1 = new ArrayList<Opcion>();
        opcionesMarcadas1.add(correcta1);
        opcionesMarcadas1.add(correcta2);
        List <Opcion> opcionesMarcadas2 = new ArrayList<Opcion>();
        opcionesMarcadas2.add(correcta3);

        List <Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(2, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }

    @Test
    public void preguntaMultipleChoiceParcialPuntuaAJugadoresCorrectamenteSiAmbosEligenAlMenosUnaOpcionIncorrecta(){
        Opcion correcta1 = new Opcion("opcion1", new Correcta());
        Opcion correcta2 = new Opcion("opcion2", new Correcta());
        Opcion incorrecta = new Opcion("opcion4", new SinPenalidad());
        List <Opcion> opciones = new ArrayList<Opcion>(){
            {add(correcta1); add(correcta2); add(incorrecta);};
        };

        Pregunta pregunta = new MultipleChoiceParcial(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Agus");
        Jugador jugador2 = new Jugador("Santi");

        List <Opcion> opcionesMarcadas1 = new ArrayList<Opcion>();
        opcionesMarcadas1.add(correcta1);
        opcionesMarcadas1.add(incorrecta);
        List <Opcion> opcionesMarcadas2 = new ArrayList<Opcion>();
        opcionesMarcadas2.add(incorrecta);
        opcionesMarcadas2.add(correcta2);
        opcionesMarcadas2.add(correcta1);

        List <Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }
}
