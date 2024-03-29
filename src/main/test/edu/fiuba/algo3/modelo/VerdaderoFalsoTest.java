package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Correcta;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.SinPenalidad;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {
    @Test
    public void preguntaVerdaderoFalsoSeCreaConRespuestaCorrectaTest(){
        ArrayList <Opcion> opciones = new ArrayList<>();
        opciones.add(new Opcion("opcion1", new Correcta()));
        opciones.add(new Opcion("opcion2", new SinPenalidad()));

        Pregunta pregunta = new VerdaderoFalso(opciones,"una pregunta");

        assertEquals(1, pregunta.cantidadOpcionesCorrectas());
    }

    @Test
    public void preguntaVerdaderoFalsoSeCreaConTextoCorrectoTest(){
        ArrayList <Opcion> opciones = new ArrayList<>();
        opciones.add(new Opcion("opcion1", new Correcta()));
        opciones.add(new Opcion("opcion2", new SinPenalidad()));

        Pregunta pregunta = new VerdaderoFalso(opciones,"una pregunta");

        assertEquals("una pregunta", pregunta.getTexto());
    }

    @Test
    public void preguntaVerdaderoFalsoAsignaUnPuntoSiEligenRespuestaCorrectaTest(){
        List <Opcion> opciones = new ArrayList<>();
        Opcion correcta = new Opcion("opcion1", new Correcta());
        opciones.add(correcta);
        opciones.add(new Opcion("opcion2", new SinPenalidad()));

        Pregunta pregunta = new VerdaderoFalso(opciones,"una pregunta");
        Jugador jugador1 = new Jugador("Cami");
        Jugador jugador2 = new Jugador("Kevin");
        List <Opcion> opcionesMarcadas1 = new ArrayList<>();
        List <Opcion> opcionesMarcadas2 = new ArrayList<>();
        opcionesMarcadas1.add(correcta);
        opcionesMarcadas2.add(correcta);
        List <Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }

    @Test
    public void preguntaVerdaderoFalsoNoAsignaPuntosSiEligenRespuestaIncorrectaTest(){

        List <Opcion> opciones = new ArrayList<>();
        Opcion incorrecta = new Opcion("opcion1", new SinPenalidad());
        opciones.add(incorrecta);
        opciones.add(new Opcion("opcion2", new Correcta()));

        Pregunta pregunta = new VerdaderoFalso(opciones,"una pregunta");
        Jugador jugador1 = new Jugador("Cami");
        Jugador jugador2 = new Jugador("Kevin");
        List <Opcion> opcionesMarcadas1 = new ArrayList<>();
        List <Opcion> opcionesMarcadas2 = new ArrayList<>();
        opcionesMarcadas1.add(incorrecta);
        opcionesMarcadas2.add(incorrecta);
        List <Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1));
        respuestas.add(new Respuesta(opcionesMarcadas2, jugador2));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }

    @Test
    public void preguntaVerdaderoFalsoPuntuaCorrectamenteSiSeEligeRespuestaCorrectaTest(){
        Opcion correcta = new Opcion("opcion1", new Correcta());
        Opcion incorrecta = new Opcion("opcion2", new SinPenalidad());
        List <Opcion> opciones = new ArrayList<>() {
            {
                add(correcta);
                add(incorrecta);
            }
        };
        Pregunta pregunta = new VerdaderoFalso(opciones, "una pregunta");

        List <Opcion> opcionesMarcadas = new ArrayList<>() {
            {add(correcta);}
        };

        Respuesta respuesta = new Respuesta(opcionesMarcadas, new Jugador("santi"));

        assertEquals(1, pregunta.puntuar(respuesta));
    }

    @Test
    public void preguntaVerdaderoFalsoPuntuaCorrectamenteSiSeEligeRespuestaInorrectaTest(){
        Opcion correcta = new Opcion("opcion1", new Correcta());
        Opcion incorrecta = new Opcion("opcion2", new SinPenalidad());
        List <Opcion> opciones = new ArrayList<>() {
            {
                add(correcta);
                add(incorrecta);
            }
        };
        Pregunta pregunta = new VerdaderoFalso(opciones, "una pregunta");

        List <Opcion> opcionesMarcadas = new ArrayList<>() {
            {add(incorrecta);}
        };

        Respuesta respuesta = new Respuesta(opcionesMarcadas, new Jugador("santi"));

        assertEquals(0, pregunta.puntuar(respuesta));
    }

    @Test
    public void preguntaVerdaderoFalsoPuntuaCeroPuntosARespuestaVaciaTest(){
        Opcion correcta = new Opcion("opcion1", new Correcta());
        Opcion incorrecta = new Opcion("opcion2", new SinPenalidad());
        List <Opcion> opciones = new ArrayList<>() {
            {
                add(correcta);
                add(incorrecta);
            }
        };
        Pregunta pregunta = new VerdaderoFalso(opciones, "una pregunta");

        Respuesta respuesta = new Respuesta(new ArrayList<Opcion>(), new Jugador("santi"));

        assertEquals(0, pregunta.puntuar(respuesta));
    }
}


