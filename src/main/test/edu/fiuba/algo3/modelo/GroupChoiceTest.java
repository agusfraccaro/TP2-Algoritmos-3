package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupChoiceTest {

    @Test
    public void preguntaGroupChoiceAsignaPuntosSiAmbosAgrupanLasOpcionesCorrectamenteTest(){
        Opcion opcion1 = new Opcion("opcion1", "Grupo1");
        Opcion opcion2 = new Opcion("opcion2", "Grupo2");
        Opcion opcion3 = new Opcion("opcion3", "Grupo2");

        List<Opcion> opciones = new ArrayList<Opcion>(){
            {add(opcion1); add(opcion2); add(opcion3);};
        };

        Pregunta pregunta = new GroupChoice(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Santi");
        Jugador jugador2 = new Jugador("Kevin");

        Opcion opcion1Jugador1 = new Opcion("opcion1", "Grupo1");
        Opcion opcion2Jugador1 = new Opcion("opcion2", "Grupo2");
        Opcion opcion3Jugador1 = new Opcion("opcion3", "Grupo2");
        List <Opcion> opcionesMarcadas1 = new ArrayList<Opcion>(){
            {add(opcion1Jugador1); add(opcion2Jugador1); add(opcion3Jugador1);}
        };

        Opcion opcion1Jugador2 = new Opcion("opcion1", "Grupo1");
        Opcion opcion2Jugador2 = new Opcion("opcion2", "Grupo2");
        Opcion opcion3Jugador2 = new Opcion("opcion3", "Grupo2");
        List <Opcion> opcionesMarcadas2 = new ArrayList<Opcion>(){
            {add(opcion1Jugador1); add(opcion2Jugador1); add(opcion3Jugador1);}
        };

        List <Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1, new Multiplicador(1)));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2, new Multiplicador(1)));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }

    @Test
    public void preguntaGroupChoiceNoAsignaPuntosAlJugadorQueAgrupeMalTest(){
        Opcion opcion1 = new Opcion("opcion1", "Grupo1");
        Opcion opcion2 = new Opcion("opcion2", "Grupo2");
        Opcion opcion3 = new Opcion("opcion3", "Grupo2");

        List<Opcion> opciones = new ArrayList<Opcion>(){
            {add(opcion1); add(opcion2); add(opcion3);};
        };

        Pregunta pregunta = new GroupChoice(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Agus");
        Jugador jugador2 = new Jugador("Kevin");

        List <Opcion> opcionesMarcadas1 = new ArrayList<Opcion>(){
            {add(new Opcion("opcion1", "Grupo2")); add(new Opcion("opcion2", "Grupo2"));
            add(new Opcion("opcion3", "Grupo1"));}
        };

        List <Opcion> opcionesMarcadas2 = new ArrayList<Opcion>(){
            {add(new Opcion("opcion1", "Grupo1")); add(new Opcion("opcion2", "Grupo2"));
                add(new Opcion("opcion3", "Grupo2"));}
        };

        List <Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1, new Multiplicador(1)));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2, new Multiplicador(1)));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }

    @Test
    public void preguntaGroupChoiceNoAsignaPuntosANingunJugadorPorqueAgrupanAmbosMalTest(){
        Opcion opcion1 = new Opcion("opcion1", "Grupo1");
        Opcion opcion2 = new Opcion("opcion2", "Grupo2");
        Opcion opcion3 = new Opcion("opcion3", "Grupo2");

        List<Opcion> opciones = new ArrayList<Opcion>(){
            {add(opcion1); add(opcion2); add(opcion3);};
        };

        Pregunta pregunta = new GroupChoice(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Agus");
        Jugador jugador2 = new Jugador("Kevin");

        List <Opcion> opcionesMarcadas1 = new ArrayList<Opcion>(){
            {add(new Opcion("opcion1", "Grupo2")); add(new Opcion("opcion2", "Grupo2"));
                add(new Opcion("opcion3", "Grupo1"));}
        };

        List <Opcion> opcionesMarcadas2 = new ArrayList<Opcion>(){
            {add(new Opcion("opcion1", "Grupo1")); add(new Opcion("opcion2", "Grupo1"));
                add(new Opcion("opcion3", "Grupo2"));}
        };

        List <Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1, new Multiplicador(1)));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2, new Multiplicador(1)));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }

}
