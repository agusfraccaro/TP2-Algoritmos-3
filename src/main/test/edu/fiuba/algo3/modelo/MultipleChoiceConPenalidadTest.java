package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.ConPenalidad;
import edu.fiuba.algo3.modelo.opcion.Correcta;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoiceParcial;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceConPenalidadTest {
    @Test
    public void preguntaMultipleChoiceConPenalidadSeCreaConOpcionesCorrectasTest() {

        Opcion correcta1 = new Opcion("opcion1", new Correcta());
        Opcion correcta2 = new Opcion("opcion2", new Correcta());
        Opcion correcta3 = new Opcion("opcion3", new Correcta());
        List<Opcion> opciones = new ArrayList<>(){
            {add(correcta1); add(correcta2); add(correcta3);}
        };

        Pregunta pregunta = new MultipleChoiceParcial(opciones, "Pregunta Test");
        assertEquals(3, pregunta.cantidadRespuestasCorrectas());
    }

    @Test
    public void preguntaMultipleChoiceConPenalidadSeCreaConOpcionesIncorrectasTest() {
        Opcion incorrecta1 = new Opcion("opcion1", new ConPenalidad());
        Opcion incorrecta2 = new Opcion("opcion2", new ConPenalidad());
        Opcion incorrecta3 = new Opcion("opcion3", new ConPenalidad());
        List<Opcion> opciones = new ArrayList<>(){
            {add(incorrecta1); add(incorrecta2); add(incorrecta3);}
        };

        Pregunta pregunta = new MultipleChoiceConPenalidad(opciones, "Pregunta Test");
        assertEquals(0, pregunta.cantidadRespuestasCorrectas());
    }

    @Test
    public void preguntaMultipleChoiceConPenalidadSeCreaConOpcionesCorrectasEIncorrectasTest() {
        Opcion incorrecta1 = new Opcion("opcion1", new ConPenalidad());
        Opcion incorrecta2 = new Opcion("opcion2", new ConPenalidad());
        Opcion incorrecta3 = new Opcion("opcion3", new ConPenalidad());
        Opcion correcta1 = new Opcion("opcion4", new Correcta());
        Opcion correcta2 = new Opcion("opcion5", new Correcta());
        List<Opcion> opciones = new ArrayList<>(){
            {add(incorrecta1); add(incorrecta2); add(incorrecta3); add(correcta1); add(correcta2);}
        };

        Pregunta pregunta = new MultipleChoiceConPenalidad(opciones, "Pregunta Test");

        assertEquals(2, pregunta.cantidadRespuestasCorrectas());
    }

    @Test
    public void preguntaMultipleChoiceConPenalidadEvaluaCorrectamenteAJugadorQueNoSeEquivocaTest() {
        Opcion incorrecta1 = new Opcion("opcion1", new ConPenalidad());
        Opcion incorrecta2 = new Opcion("opcion2", new ConPenalidad());
        Opcion incorrecta3 = new Opcion("opcion3", new ConPenalidad());
        Opcion correcta1 = new Opcion("opcion4", new Correcta());
        Opcion correcta2 = new Opcion("opcion5", new Correcta());
        List<Opcion> opciones = new ArrayList<>(){
            {add(incorrecta1); add(incorrecta2); add(incorrecta3); add(correcta1); add(correcta2);}
        };

        Pregunta pregunta = new MultipleChoiceConPenalidad(opciones, "Pregunta Test");
        Jugador jugador = new Jugador("Maximus Decimus Meridius");
        List<Opcion> opcionesMarcadas = new ArrayList<>();
        opcionesMarcadas.add(correcta1);
        opcionesMarcadas.add(correcta2);
        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(opcionesMarcadas, jugador));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(2, jugador.getPuntaje());
    }

    @Test
    public void preguntaMultipleChoiceConPenalidadEvaluaCorrectamenteAJugadorQueSeEquivocaTest() {
        Opcion incorrecta1 = new Opcion("opcion1", new ConPenalidad());
        Opcion incorrecta2 = new Opcion("opcion2", new ConPenalidad());
        Opcion incorrecta3 = new Opcion("opcion3", new ConPenalidad());
        Opcion correcta1 = new Opcion("opcion4", new Correcta());
        Opcion correcta2 = new Opcion("opcion5", new Correcta());
        List<Opcion> opciones = new ArrayList<>(){
            {add(incorrecta1); add(incorrecta2); add(incorrecta3); add(correcta1); add(correcta2);}
        };

        Pregunta pregunta = new MultipleChoiceConPenalidad(opciones, "Pregunta Test");

        Jugador jugador = new Jugador("Maximus Decimus Meridius");
        List<Opcion> opcionesMarcadas = new ArrayList<>();
        opcionesMarcadas.add(incorrecta1);
        opcionesMarcadas.add(incorrecta2);
        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(opcionesMarcadas, jugador));

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(-2, jugador.getPuntaje());
    }

    @Test
    public void preguntaMultipleChoiceConPenalidadPuntuaCorrectamenteAJugadorQueNoSeEquivocaTest(){
        Opcion incorrecta1 = new Opcion("opcion1", new ConPenalidad());
        Opcion incorrecta2 = new Opcion("opcion2", new ConPenalidad());
        Opcion incorrecta3 = new Opcion("opcion3", new ConPenalidad());
        Opcion correcta1 = new Opcion("opcion4", new Correcta());
        Opcion correcta2 = new Opcion("opcion5", new Correcta());
        List<Opcion> opciones = new ArrayList<>(){
            {add(incorrecta1); add(incorrecta2); add(incorrecta3); add(correcta1); add(correcta2);}
        };

        Pregunta pregunta = new MultipleChoiceConPenalidad(opciones, "Pregunta Test");

        List<Opcion> opcionesMarcadas = new ArrayList<>(){
            {add(correcta1); add(correcta2);}
        };

        Respuesta respuesta = new Respuesta(opcionesMarcadas, new Jugador("cami"));

        assertEquals(2, pregunta.puntuar(respuesta));
    }

    @Test
    public void preguntaMultipleChoiceConPenalidadPuntuaCorrectamenteAJugadorQueSeEquivocaTest(){
        Opcion incorrecta1 = new Opcion("opcion1", new ConPenalidad());
        Opcion incorrecta2 = new Opcion("opcion2", new ConPenalidad());
        Opcion incorrecta3 = new Opcion("opcion3", new ConPenalidad());
        Opcion correcta1 = new Opcion("opcion4", new Correcta());
        Opcion correcta2 = new Opcion("opcion5", new Correcta());
        List<Opcion> opciones = new ArrayList<>(){
            {add(incorrecta1); add(incorrecta2); add(incorrecta3); add(correcta1); add(correcta2);}
        };

        Pregunta pregunta = new MultipleChoiceConPenalidad(opciones, "Pregunta Test");

        List<Opcion> opcionesMarcadas = new ArrayList<>(){
            {add(incorrecta2); add(correcta2); add(incorrecta3);}
        };

        Respuesta respuesta = new Respuesta(opcionesMarcadas, new Jugador("cami"));

        assertEquals(-1, pregunta.puntuar(respuesta));
    }

    @Test
    public void preguntaMultipleChoiceConPenalidadPuntuaCeroPuntosARespuestaVaciaTest(){
        Opcion incorrecta1 = new Opcion("opcion1", new ConPenalidad());
        Opcion incorrecta2 = new Opcion("opcion2", new ConPenalidad());
        Opcion incorrecta3 = new Opcion("opcion3", new ConPenalidad());
        Opcion correcta1 = new Opcion("opcion4", new Correcta());
        Opcion correcta2 = new Opcion("opcion5", new Correcta());
        List<Opcion> opciones = new ArrayList<>(){
            {add(incorrecta1); add(incorrecta2); add(incorrecta3); add(correcta1); add(correcta2);}
        };

        Pregunta pregunta = new MultipleChoiceConPenalidad(opciones, "Pregunta Test");

        Respuesta respuesta = new Respuesta(new ArrayList<Opcion>(), new Jugador("cami"));

        assertEquals(0, pregunta.puntuar(respuesta));
    }
}

