package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceClasicoTest {
    @Test
    public void preguntaMultipleChoiceClásicoSeCreaConOpcionesCorrectasTest(){
        Opcion correcta1 = new Opcion("opcion1", new Correcta());
        Opcion correcta2 = new Opcion("opcion2", new Correcta());
        Opcion incorrecta = new Opcion("opcion3", new SinPenalidad());

        List <Opcion> opciones = new ArrayList<Opcion>() {
            {add(correcta1); add(correcta2); add(incorrecta);};
        };

        Pregunta pregunta = new MultipleChoiceParcial(opciones, "una pregunta");

        assertEquals(2, pregunta.cantidadRespuestasCorrectas());
    }

    @Test
    public void preguntaMultipleChoiceClasicoPuntuaAJugadoresCorrectamenteSiEligenOpcionesCorrectas(){
        Opcion correcta1 = new Opcion("opcion1", new Correcta());
        Opcion correcta2 = new Opcion("opcion2", new Correcta());
        Opcion correcta3 = new Opcion("opcion3", new Correcta());

        List <Opcion> opciones = new ArrayList<Opcion>() {
            {add(correcta1); add(correcta2); add(correcta3); add(new Opcion("opcion4", new SinPenalidad()));}
        };

        Pregunta pregunta = new MultipleChoiceClasico(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Kevin");
        Jugador jugador2 = new Jugador("Cami");
        List <Opcion> opcionesMarcadas1 = new ArrayList<Opcion>(){
            {add(correcta1); add(correcta2); add(correcta3);}
        };
        List <Opcion> opcionesMarcadas2 = new ArrayList<Opcion>(){
            {add(correcta1); add(correcta2); add(correcta3);}
        };

        List <Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1, new Multiplicador(1)));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2, new Multiplicador(1)));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }

    @Test
    public void preguntaMultipleChoiceClasicoNoSumaNingunPuntoSiJugadoresNoEligenTodasLasOpcionesCorrectasTest(){
        Opcion correcta1 = new Opcion("opcion1", new Correcta());
        Opcion correcta2 = new Opcion("opcion2", new Correcta());
        Opcion correcta3 = new Opcion("opcion3", new Correcta());

        List <Opcion> opciones = new ArrayList<Opcion>() {
            {add(correcta1); add(correcta2); add(correcta3); add(new Opcion("opcion4", new SinPenalidad()));}
        };

        Pregunta pregunta = new MultipleChoiceClasico(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Kevin");
        Jugador jugador2 = new Jugador("Cami");
        List <Opcion> opcionesMarcadas1 = new ArrayList<Opcion>(){
            {add(correcta1); add(correcta2);}
        };
        List <Opcion> opcionesMarcadas2 = new ArrayList<Opcion>(){
            {add(correcta3);}
        };

        List <Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1, new Multiplicador(1)));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2, new Multiplicador(1)));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }

    @Test
    public void preguntaMultipleChoiceClasicoNoSumaPuntosSiEligenTodasLasOpcionesCorrectasYAlgunaIncorrectaTest() {
        Opcion correcta1 = new Opcion("opcion1", new Correcta());
        Opcion correcta2 = new Opcion("opcion2", new Correcta());
        Opcion correcta3 = new Opcion("opcion3", new Correcta());
        Opcion incorrecta1 = new Opcion("opcion4", new SinPenalidad());
        Opcion incorrecta2 = new Opcion("opcion5", new SinPenalidad());

        List<Opcion> opciones = new ArrayList<Opcion>() {
            {add(correcta1); add(correcta2); add(correcta3); add(incorrecta1); add(incorrecta2);}
        };

        Pregunta pregunta = new MultipleChoiceClasico(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Kevin");
        Jugador jugador2 = new Jugador("Cami");
        List<Opcion> opcionesMarcadas1 = new ArrayList<Opcion>() {
            {add(correcta1); add(correcta2); add(correcta3); add(incorrecta1);}
        };
        List<Opcion> opcionesMarcadas2 = new ArrayList<Opcion>() {
            {add(correcta1); add(correcta2); add(correcta3); add(incorrecta1); add(incorrecta2);}
        };

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1, new Multiplicador(1)));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2, new Multiplicador(1)));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());

    }

}
