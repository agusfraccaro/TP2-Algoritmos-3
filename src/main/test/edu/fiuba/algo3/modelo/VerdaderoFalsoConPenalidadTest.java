package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.ConPenalidad;
import edu.fiuba.algo3.modelo.opcion.Correcta;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalsoConPenalidad;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoConPenalidadTest {
    @Test
    public void preguntaVerdaderoFalsoSeCreaConTextoCorrectoTest(){
        Opcion correcta = new Opcion("opcion1", new Correcta());
        Opcion incorrecta = new Opcion("opcion2", new ConPenalidad());
        List <Opcion> opciones = new ArrayList<>() {
            {
                add(correcta);
                add(incorrecta);
            }
        };
        Pregunta pregunta = new VerdaderoFalsoConPenalidad(opciones, "una pregunta");

        assertEquals("una pregunta", pregunta.getTexto());
    }

    @Test
    public void preguntaVerdaderoFalsoConPenalidadSumaPuntosAAmbosJugadoresQueEligeRespuestaCorrectaTest(){
        Opcion correcta = new Opcion("opcion1", new Correcta());
        Opcion incorrecta = new Opcion("opcion2", new ConPenalidad());
        List <Opcion> opciones = new ArrayList<>() {
            {
                add(correcta);
                add(incorrecta);
            }
        };
        Pregunta pregunta = new VerdaderoFalsoConPenalidad(opciones, "una pregunta");
        Jugador jugador1 = new Jugador("Cami");
        Jugador jugador2 = new Jugador("Kevin");
        List <Opcion> opcionesMarcadasJugador1 = new ArrayList<>();
        List <Opcion> opcionesMarcadasJugador2 = new ArrayList<>();
        opcionesMarcadasJugador1.add(correcta);
        opcionesMarcadasJugador2.add(correcta);
        List <Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(opcionesMarcadasJugador1, jugador1));
        respuestas.add(new Respuesta(opcionesMarcadasJugador2, jugador2));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());

    }

    @Test
    public void preguntaVerdaderoFalsoConPenalidadRestaPuntosAJugador1QueEligeRespuestaIncorrectaYSumaPuntoAJugador2QueEligeRespuestaCorrectaTest(){
        Opcion correcta = new Opcion("opcion1", new Correcta());
        Opcion incorrecta = new Opcion("opcion2", new ConPenalidad());
        List <Opcion> opciones = new ArrayList<>() {
            {
                add(correcta);
                add(incorrecta);
            }
        };
        Pregunta pregunta = new VerdaderoFalsoConPenalidad(opciones, "una pregunta");
        Jugador jugador1 = new Jugador("Cami");
        Jugador jugador2 = new Jugador("Kevin");
        List <Opcion> opcionesMarcadasJugador1 = new ArrayList<>();
        List <Opcion> opcionesMarcadasJugador2 = new ArrayList<>();
        opcionesMarcadasJugador1.add(incorrecta);
        opcionesMarcadasJugador2.add(correcta);
        List <Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(opcionesMarcadasJugador1, jugador1));
        respuestas.add(new Respuesta(opcionesMarcadasJugador2, jugador2));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(-1, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());

    }

    @Test
    public void preguntaVerdaderoFalsoConPenalidadRestaPuntosSiSeEligeRespuestaIncorrectaTest(){
        Opcion correcta = new Opcion("opcion1", new Correcta());
        Opcion incorrecta = new Opcion("opcion2", new ConPenalidad());
        List <Opcion> opciones = new ArrayList<>() {
            {
                add(correcta);
                add(incorrecta);
            }
        };
        Pregunta pregunta = new VerdaderoFalsoConPenalidad(opciones, "una pregunta");
        Jugador jugador1 = new Jugador("Cami");
        Jugador jugador2 = new Jugador("Kevin");
        List <Opcion> opcionesMarcadasJugador1 = new ArrayList<>();
        List <Opcion> opcionesMarcadasJugador2 = new ArrayList<>();
        opcionesMarcadasJugador1.add(incorrecta);
        opcionesMarcadasJugador2.add(incorrecta);
        List <Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(opcionesMarcadasJugador1, jugador1));
        respuestas.add(new Respuesta(opcionesMarcadasJugador2, jugador2));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(-1, jugador1.getPuntaje());
        assertEquals(-1, jugador2.getPuntaje());

    }

    @Test
    public void preguntaVerdaderoFalsoConPenalidadPuntuaCorrectamenteSiSeEligeRespuestaCorrectaTest(){
        Opcion correcta = new Opcion("opcion1", new Correcta());
        Opcion incorrecta = new Opcion("opcion2", new ConPenalidad());
        List <Opcion> opciones = new ArrayList<>() {
            {
                add(correcta);
                add(incorrecta);
            }
        };
        Pregunta pregunta = new VerdaderoFalsoConPenalidad(opciones, "una pregunta");

        List <Opcion> opcionesMarcadas = new ArrayList<>() {
            {add(correcta);}
        };

        Respuesta respuesta = new Respuesta(opcionesMarcadas, new Jugador("cami"));

        assertEquals(1, pregunta.puntuar(respuesta));
    }

    @Test
    public void preguntaVerdaderoFalsoConPenalidadPuntuaCorrectamenteSiSeEligeRespuestaInorrectaTest(){
        Opcion correcta = new Opcion("opcion1", new Correcta());
        Opcion incorrecta = new Opcion("opcion2", new ConPenalidad());
        List <Opcion> opciones = new ArrayList<>() {
            {
                add(correcta);
                add(incorrecta);
            }
        };
        Pregunta pregunta = new VerdaderoFalsoConPenalidad(opciones, "una pregunta");

        List <Opcion> opcionesMarcadas = new ArrayList<>() {
            {add(incorrecta);}
        };

        Respuesta respuesta = new Respuesta(opcionesMarcadas, new Jugador("cami"));

        assertEquals(-1, pregunta.puntuar(respuesta));
    }

    @Test
    public void preguntaVerdaderoFalsoConPenalidadPuntuaCeroPuntosARespuestaVaciaTest(){
        Opcion correcta = new Opcion("opcion1", new Correcta());
        Opcion incorrecta = new Opcion("opcion2", new ConPenalidad());
        List <Opcion> opciones = new ArrayList<>() {
            {
                add(correcta);
                add(incorrecta);
            }
        };
        Pregunta pregunta = new VerdaderoFalsoConPenalidad(opciones, "una pregunta");

        Respuesta respuesta = new Respuesta(new ArrayList<Opcion>(), new Jugador("cami"));

        assertEquals(0, pregunta.puntuar(respuesta));
    }
}


