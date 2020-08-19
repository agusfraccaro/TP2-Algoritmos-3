package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.preguntas.OrderedChoice;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderedChoiceTest {
    @Test
    public void preguntaOrderedChoiceSeCreaConTextoCorrectoTest(){
        Opcion opcion1 = new Opcion("opcion1");
        Opcion opcion2 = new Opcion("opcion2");

        List <Opcion> opciones = new ArrayList<>() {
            {
                add(opcion1);
                add(opcion2);
            }
        };

        Pregunta pregunta = new OrderedChoice(opciones, "una pregunta");

        assertEquals("una pregunta", pregunta.getTexto());
    }

    @Test
    public void preguntaOrderedChoiceAsignaUnPuntoSiAmbosJugadoresOrdenanCorrectamenteLasOpcionesTest(){
        Opcion opcion1 = new Opcion("opcion1");
        Opcion opcion2 = new Opcion("opcion2");
        Opcion opcion3 = new Opcion("opcion3");

        List <Opcion> opciones = new ArrayList<>() {
            {
                add(opcion1);
                add(opcion2);
                add(opcion3);
            }
        };

        Pregunta pregunta = new OrderedChoice(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Agus");
        Jugador jugador2 = new Jugador("Cami");
        List <Opcion> opcionesMarcadas1 = new ArrayList<>() {
            {
                add(opcion1);
                add(opcion2);
                add(opcion3);
            }
        };
        List <Opcion> opcionesMarcadas2 = new ArrayList<>() {
            {
                add(opcion1);
                add(opcion2);
                add(opcion3);
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
    public void preguntaOrderedChoiceNoAsignaPuntosAlJugadorQueNoOrdeneCorrectamenteTest(){
        Opcion opcion1 = new Opcion("opcion1");
        Opcion opcion2 = new Opcion("opcion2");
        Opcion opcion3 = new Opcion("opcion3");

        List <Opcion> opciones = new ArrayList<>() {
            {
                add(opcion1);
                add(opcion2);
                add(opcion3);
            }
        };

        Pregunta pregunta = new OrderedChoice(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Agus");
        Jugador jugador2 = new Jugador("Cami");
        List <Opcion> opcionesMarcadas1 = new ArrayList<>() {
            {
                add(opcion3);
                add(opcion1);
                add(opcion2);
            }
        };
        List <Opcion> opcionesMarcadas2 = new ArrayList<>() {
            {
                add(opcion1);
                add(opcion2);
                add(opcion3);
            }
        };

        List <Respuesta> respuestas = new ArrayList<>();
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

        List <Opcion> opciones = new ArrayList<>() {
            {
                add(opcion1);
                add(opcion2);
                add(opcion3);
            }
        };

        Pregunta pregunta = new OrderedChoice(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Agus");
        Jugador jugador2 = new Jugador("Cami");
        List <Opcion> opcionesMarcadas1 = new ArrayList<>() {
            {
                add(opcion3);
                add(opcion1);
                add(opcion2);
            }
        };
        List <Opcion> opcionesMarcadas2 = new ArrayList<>() {
            {
                add(opcion2);
                add(opcion3);
                add(opcion1);
            }
        };

        List <Respuesta> respuestas = new ArrayList<>();
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

        List <Opcion> opciones = new ArrayList<>() {
            {
                add(opcion1);
                add(opcion2);
                add(opcion3);
            }
        };

        Pregunta pregunta = new OrderedChoice(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Agus");
        Jugador jugador2 = new Jugador("Cami");
        List <Opcion> opcionesMarcadas1 = new ArrayList<>() {
            {
                add(opcion1);
                add(opcion2);
            }
        };
        List <Opcion> opcionesMarcadas2 = new ArrayList<>() {
            {
                add(opcion3);
                add(opcion2);
            }
        };

        List <Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }

    @Test
    public void preguntaOrderedChoicePuntuaCorrectamenteUnaRespuestaBienOrdenadaTest(){
        Opcion opcion1 = new Opcion("opcion1");
        Opcion opcion2 = new Opcion("opcion2");
        Opcion opcion3 = new Opcion("opcion3");

        List <Opcion> opciones = new ArrayList<>() {
            {
                add(opcion1);
                add(opcion2);
                add(opcion3);
            }
        };

        Pregunta pregunta = new OrderedChoice(opciones, "una pregunta");

        List <Opcion> opcionesMarcadas = new ArrayList<>() {
            {
                add(opcion1);
                add(opcion2);
                add(opcion3);
            }
        };

        Respuesta respuesta = new Respuesta(opcionesMarcadas, new Jugador("santi"));

        assertEquals(1, pregunta.puntuar(respuesta));
    }

    @Test
    public void preguntaOrderedChoicePuntuaCorrectamenteUnaRespuestaMalOrdenadaTest(){
        Opcion opcion1 = new Opcion("opcion1");
        Opcion opcion2 = new Opcion("opcion2");
        Opcion opcion3 = new Opcion("opcion3");

        List <Opcion> opciones = new ArrayList<>() {
            {
                add(opcion1);
                add(opcion2);
                add(opcion3);
            }
        };

        Pregunta pregunta = new OrderedChoice(opciones, "una pregunta");

        List <Opcion> opcionesMarcadas = new ArrayList<>() {
            {
                add(opcion3);
                add(opcion2);
                add(opcion1);
            }
        };

        Respuesta respuesta = new Respuesta(opcionesMarcadas, new Jugador("kevin"));

        assertEquals(0, pregunta.puntuar(respuesta));
    }

    @Test
    public void preguntaOrderedChoicePuntuaCeroPuntosARespuestaVaciaTest(){
        Opcion opcion1 = new Opcion("opcion1");
        Opcion opcion2 = new Opcion("opcion2");
        Opcion opcion3 = new Opcion("opcion3");

        List <Opcion> opciones = new ArrayList<>() {
            {
                add(opcion1);
                add(opcion2);
                add(opcion3);
            }
        };

        Pregunta pregunta = new OrderedChoice(opciones, "una pregunta");

        Respuesta respuesta = new Respuesta(new ArrayList<Opcion>(), new Jugador("kevin"));

        assertEquals(0, pregunta.puntuar(respuesta));
    }
}
