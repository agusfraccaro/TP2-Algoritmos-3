package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupChoiceTest {
    @Test
    public void preguntaGroupChoiceSeCreaConTextoCorrectoTest() {
        Opcion opcion1 = new Opcion("opcion1", "Grupo1");
        Opcion opcion2 = new Opcion("opcion2", "Grupo2");
        Opcion opcion3 = new Opcion("opcion3", "Grupo2");

        List<Opcion> opciones = new ArrayList<>() {
            {
                add(opcion1);
                add(opcion2);
                add(opcion3);
            }
        };

        Pregunta pregunta = new GroupChoice(opciones, "una pregunta");

        assertEquals("una pregunta", pregunta.getTexto());
    }

    @Test
    public void preguntaGroupChoiceSeCreaConListaDeOpcionesCorrectamenteTest() {
        Opcion opcion1 = new Opcion("opcion1", "Grupo1");
        Opcion opcion2 = new Opcion("opcion2", "Grupo2");
        Opcion opcion3 = new Opcion("opcion3", "Grupo2");

        List<Opcion> opciones = new ArrayList<>() {
            {
                add(opcion1);
                add(opcion2);
                add(opcion3);
            }
        };

        Pregunta pregunta = new GroupChoice(opciones, "una pregunta");

        assertEquals(opciones, pregunta.getOpciones());
    }

    @Test
    public void preguntaGroupChoiceAsignaPuntosSiAmbosAgrupanLasOpcionesCorrectamenteTest(){
        Opcion opcion1 = new Opcion("opcion1", "Grupo1");
        Opcion opcion2 = new Opcion("opcion2", "Grupo2");
        Opcion opcion3 = new Opcion("opcion3", "Grupo2");

        List<Opcion> opciones = new ArrayList<>() {
            {
                add(opcion1);
                add(opcion2);
                add(opcion3);
            }
        };

        Pregunta pregunta = new GroupChoice(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Santi");
        Jugador jugador2 = new Jugador("Kevin");

        Opcion opcion1Jugador1 = new Opcion("opcion1", "Grupo1");
        Opcion opcion2Jugador1 = new Opcion("opcion2", "Grupo2");
        Opcion opcion3Jugador1 = new Opcion("opcion3", "Grupo2");
        List <Opcion> opcionesMarcadas1 = new ArrayList<>() {
            {
                add(opcion1Jugador1);
                add(opcion2Jugador1);
                add(opcion3Jugador1);
            }
        };

        Opcion opcion1Jugador2 = new Opcion("opcion1", "Grupo1");
        Opcion opcion2Jugador2 = new Opcion("opcion2", "Grupo2");
        Opcion opcion3Jugador2 = new Opcion("opcion3", "Grupo2");
        List <Opcion> opcionesMarcadas2 = new ArrayList<>() {
            {
                add(opcion1Jugador2);
                add(opcion2Jugador2);
                add(opcion3Jugador2);
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
    public void preguntaGroupChoiceNoAsignaPuntosAlJugadorQueAgrupeMalTest(){
        Opcion opcion1 = new Opcion("opcion1", "Grupo1");
        Opcion opcion2 = new Opcion("opcion2", "Grupo2");
        Opcion opcion3 = new Opcion("opcion3", "Grupo2");

        List<Opcion> opciones = new ArrayList<>() {
            {
                add(opcion1);
                add(opcion2);
                add(opcion3);
            }
        };

        Pregunta pregunta = new GroupChoice(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Agus");
        Jugador jugador2 = new Jugador("Kevin");

        List <Opcion> opcionesMarcadas1 = new ArrayList<>() {
            {
                add(new Opcion("opcion1", "Grupo2"));
                add(new Opcion("opcion2", "Grupo2"));
                add(new Opcion("opcion3", "Grupo1"));
            }
        };

        List <Opcion> opcionesMarcadas2 = new ArrayList<>() {
            {
                add(new Opcion("opcion1", "Grupo1"));
                add(new Opcion("opcion2", "Grupo2"));
                add(new Opcion("opcion3", "Grupo2"));
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
    public void preguntaGroupChoiceNoAsignaPuntosANingunJugadorPorqueAgrupanAmbosMalTest(){
        Opcion opcion1 = new Opcion("opcion1", "Grupo1");
        Opcion opcion2 = new Opcion("opcion2", "Grupo2");
        Opcion opcion3 = new Opcion("opcion3", "Grupo2");

        List<Opcion> opciones = new ArrayList<>() {
            {
                add(opcion1);
                add(opcion2);
                add(opcion3);
            }
        };

        Pregunta pregunta = new GroupChoice(opciones, "una pregunta");

        Jugador jugador1 = new Jugador("Agus");
        Jugador jugador2 = new Jugador("Kevin");

        List <Opcion> opcionesMarcadas1 = new ArrayList<>() {
            {
                add(new Opcion("opcion1", "Grupo2"));
                add(new Opcion("opcion2", "Grupo2"));
                add(new Opcion("opcion3", "Grupo1"));
            }
        };

        List <Opcion> opcionesMarcadas2 = new ArrayList<>() {
            {
                add(new Opcion("opcion1", "Grupo1"));
                add(new Opcion("opcion2", "Grupo1"));
                add(new Opcion("opcion3", "Grupo2"));
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
    public void preguntaGroupChoicePuntuaCorrectamenteUnaRespuestaBienAgrupadaTest(){
        Opcion opcion1 = new Opcion("opcion1", "Grupo1");
        Opcion opcion2 = new Opcion("opcion2", "Grupo2");
        Opcion opcion3 = new Opcion("opcion3", "Grupo2");

        List<Opcion> opciones = new ArrayList<>() {
            {
                add(opcion1);
                add(opcion2);
                add(opcion3);
            }
        };

        Pregunta pregunta = new GroupChoice(opciones, "una pregunta");

        List <Opcion> opcionesMarcadas = new ArrayList<>() {
            {
                add(new Opcion("opcion1", "Grupo1"));
                add(new Opcion("opcion2", "Grupo2"));
                add(new Opcion("opcion3", "Grupo2"));
            }
        };

        Respuesta respuesta = new Respuesta(opcionesMarcadas, new Jugador("agus"));

        assertEquals(1, pregunta.puntuar(respuesta));
    }

    @Test
    public void preguntaGroupChoicePuntuaCorrectamenteUnaRespuestaMalAgrupadaTest(){
        Opcion opcion1 = new Opcion("opcion1", "Grupo1");
        Opcion opcion2 = new Opcion("opcion2", "Grupo2");
        Opcion opcion3 = new Opcion("opcion3", "Grupo2");

        List<Opcion> opciones = new ArrayList<>() {
            {
                add(opcion1);
                add(opcion2);
                add(opcion3);
            }
        };

        Pregunta pregunta = new GroupChoice(opciones, "una pregunta");

        List <Opcion> opcionesMarcadas = new ArrayList<>() {
            {
                add(new Opcion("opcion1", "Grupo1"));
                add(new Opcion("opcion2", "Grupo2"));
                add(new Opcion("opcion3", "Grupo1"));
            }
        };

        Respuesta respuesta = new Respuesta(opcionesMarcadas, new Jugador("agus"));

        assertEquals(0, pregunta.puntuar(respuesta));
    }

    @Test
    public void preguntaGroupChoicePuntuaCeroCuandoPuntuaUnaRespuestaVaciaTest(){
        Opcion opcion1 = new Opcion("opcion1", "Grupo1");
        Opcion opcion2 = new Opcion("opcion2", "Grupo2");
        Opcion opcion3 = new Opcion("opcion3", "Grupo2");

        List<Opcion> opciones = new ArrayList<>() {
            {
                add(opcion1);
                add(opcion2);
                add(opcion3);
            }
        };

        Pregunta pregunta = new GroupChoice(opciones, "una pregunta");

        Respuesta respuesta = new Respuesta(new ArrayList<Opcion>(), new Jugador("agus"));

        assertEquals(0, pregunta.puntuar(respuesta));
    }
}
