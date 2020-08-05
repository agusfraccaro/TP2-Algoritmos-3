package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceClasicoTest {
    @Test
    public void preguntaMultipleChoiceClasicoSeCreaConOpcionesCorrectasTest(){
        List <Opcion> opciones = new ArrayList<>() {
            {
                add(new Correcta("A"));
                add(new Correcta("B"));
                add(new SinPenalidad("C"));
            }
        };

        Pregunta pregunta = new MultipleChoiceParcial(opciones, "una pregunta");

        assertEquals(2, pregunta.cantidadRespuestasCorrectas());
    }

    @Test
    public void preguntaMultipleChoiceClasicoPuntuaAJugadoresCorrectamenteSiEligenOpcionesCorrectas(){
        Opcion correcta1 = new Correcta("A");
        Opcion correcta2 = new Correcta("B");
        Opcion correcta3 = new Correcta("C");
        List <Opcion> opciones = new ArrayList<>() {
            {
                add(correcta1);
                add(correcta2);
                add(correcta3);
                add(new SinPenalidad("D"));
            }
        };

        Pregunta pregunta = new MultipleChoiceClasico(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Kevin");
        Jugador jugador2 = new Jugador("Cami");
        List <Opcion> opcionesMarcadas1 = new ArrayList<>() {
            {
                add(correcta1);
                add(correcta2);
                add(correcta3);
            }
        };
        List <Opcion> opcionesMarcadas2 = new ArrayList<>() {
            {
                add(correcta1);
                add(correcta2);
                add(correcta3);
            }
        };

        List <Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }

    @Test
    public void preguntaMultipleChoiceClasicoNoSumaNingunPuntoSiJugadoresNoEligenTodasLasOpcionesCorrectasTest(){
        Opcion correcta1 = new Correcta("A");
        Opcion correcta2 = new Correcta("B");
        Opcion correcta3 = new Correcta("C");
        List<Opcion> opciones = new ArrayList<>() {
            {
                add(correcta1);
                add(correcta2);
                add(correcta3);
                add(new SinPenalidad("D"));
            }
        };

        Pregunta pregunta = new MultipleChoiceClasico(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Kevin");
        Jugador jugador2 = new Jugador("Cami");
        List <Opcion> opcionesMarcadas1 = new ArrayList<>() {
            {
                add(correcta1);
                add(correcta2);
            }
        };
        List <Opcion> opcionesMarcadas2 = new ArrayList<>() {
            {
                add(correcta3);
            }
        };

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }

    @Test
    public void preguntaMultipleChoiceClasicoNoSumaPuntosSiEligenTodasLasOpcionesCorrectasYAlgunaIncorrectaTest() {
        Opcion correcta1 = new Correcta("A");
        Opcion correcta2 = new Correcta("B");
        Opcion correcta3 = new Correcta("C");
        Opcion incorrecta1 = new SinPenalidad("D");
        Opcion incorrecta2 = new SinPenalidad("E");
        List<Opcion> opciones = new ArrayList<>() {
            {
                add(correcta1);
                add(correcta2);
                add(correcta3);
                add(incorrecta1);
                add(incorrecta2);
            }
        };

        Pregunta pregunta = new MultipleChoiceClasico(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Kevin");
        Jugador jugador2 = new Jugador("Cami");
        List<Opcion> opcionesMarcadas1 = new ArrayList<>() {
            {
                add(correcta1);
                add(correcta2);
                add(correcta3);
                add(incorrecta1);
            }
        };
        List<Opcion> opcionesMarcadas2 = new ArrayList<>() {
            {
                add(correcta1);
                add(correcta2);
                add(correcta3);
                add(incorrecta1);
                add(incorrecta2);
            }
        };

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }

}
