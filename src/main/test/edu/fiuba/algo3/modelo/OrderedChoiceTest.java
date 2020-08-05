package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderedChoiceTest {

    @Test
    public void preguntaOrderedChoiceAsignaUnPuntoSiAmbosJugadoresOrdenanCorrectamenteLasOpcionesTest(){
        Opcion opcion1 = new Opcion("opcion1");
        Opcion opcion2 = new Opcion("opcion2");
        Opcion opcion3 = new Opcion("opcion3");

        List <Opcion> opciones = new ArrayList<Opcion>(){
            {add(opcion1); add(opcion2); add(opcion3);};
        };

        Pregunta pregunta = new OrderedChoice(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Agus");
        Jugador jugador2 = new Jugador("Cami");
        List <Opcion> opcionesMarcadas1 = new ArrayList<Opcion>(){
            {add(opcion1); add(opcion2); add(opcion3);}
        };
        List <Opcion> opcionesMarcadas2 = new ArrayList<Opcion>(){
            {add(opcion1); add(opcion2); add(opcion3);}
        };

        List <Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }

    @Test
    public void preguntaOrderedChoiceNoAsignaPuntosAlJugadorQueNoOrdeneCorrectamenteTest(){
        Opcion opcion1 = new Opcion("opcion1");
        Opcion opcion2 = new Opcion("opcion2");
        Opcion opcion3 = new Opcion("opcion3");

        List <Opcion> opciones = new ArrayList<Opcion>(){
            {add(opcion1); add(opcion2); add(opcion3);};
        };

        Pregunta pregunta = new OrderedChoice(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Agus");
        Jugador jugador2 = new Jugador("Cami");
        List <Opcion> opcionesMarcadas1 = new ArrayList<Opcion>(){
            {add(opcion3); add(opcion1); add(opcion2);}
        };
        List <Opcion> opcionesMarcadas2 = new ArrayList<Opcion>(){
            {add(opcion1); add(opcion2); add(opcion3);}
        };

        List <Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }

    @Test
    public void preguntaOrderedChoiceNoAsignaPuntosANingunJugadorSiOrdenanMalLasOpcionesTest(){
        Opcion opcion1 = new Opcion("opcion1");
        Opcion opcion2 = new Opcion("opcion2");
        Opcion opcion3 = new Opcion("opcion3");

        List <Opcion> opciones = new ArrayList<Opcion>(){
            {add(opcion1); add(opcion2); add(opcion3);};
        };

        Pregunta pregunta = new OrderedChoice(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Agus");
        Jugador jugador2 = new Jugador("Cami");
        List <Opcion> opcionesMarcadas1 = new ArrayList<Opcion>(){
            {add(opcion3); add(opcion1); add(opcion2);}
        };
        List <Opcion> opcionesMarcadas2 = new ArrayList<Opcion>(){
            {add(opcion2); add(opcion3); add(opcion1);}
        };

        List <Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }

    @Test
    public void preguntaOrderedChoiceNoAsignaPuntosAlJugadorQueDejaOpcionesSinOrdenarTest(){
        Opcion opcion1 = new Opcion("opcion1");
        Opcion opcion2 = new Opcion("opcion2");
        Opcion opcion3 = new Opcion("opcion3");

        List <Opcion> opciones = new ArrayList<Opcion>(){
            {add(opcion1); add(opcion2); add(opcion3);};
        };

        Pregunta pregunta = new OrderedChoice(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Agus");
        Jugador jugador2 = new Jugador("Cami");
        List <Opcion> opcionesMarcadas1 = new ArrayList<Opcion>(){
            {add(opcion1); add(opcion2);}
        };
        List <Opcion> opcionesMarcadas2 = new ArrayList<Opcion>(){
            {add(opcion3); add(opcion2);}
        };

        List <Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }

}
