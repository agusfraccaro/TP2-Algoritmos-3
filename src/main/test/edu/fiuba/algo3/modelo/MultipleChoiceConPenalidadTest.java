package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceConPenalidadTest {
    @Test
    public void preguntaMultipleChoiceConPenalidadSeCreaConOpcionesCorrectasTest() {
        List<Opcion> opciones = new ArrayList<>();
        Opcion correcta1 = new Correcta();
        Opcion correcta2 = new Correcta();
        Opcion correcta3 = new Correcta();
        opciones.add(correcta1);
        opciones.add(correcta2);
        opciones.add(correcta3);
        Pregunta pregunta = new MultipleChoiceParcial(opciones, "Pregunta Test");
        assertEquals(3, pregunta.cantidadRespuestasCorrectas());
    }

    @Test public void preguntaMultipleChoiceConPenalidadSeCreaConOpcionesIncorrectasTest() {
        List<Opcion> opciones = new ArrayList<>();
        Opcion incorrecta1 = new ConPenalidad();
        Opcion incorrecta2 = new ConPenalidad();
        Opcion incorrecta3 = new ConPenalidad();
        opciones.add(incorrecta1);
        opciones.add(incorrecta2);
        opciones.add(incorrecta3);
        Pregunta pregunta = new MultipleChoiceConPenalidad(opciones, "Pregunta Test");
        assertEquals(0, pregunta.cantidadRespuestasCorrectas());
    }

    @Test
    public void preguntaMultipleChoiceConPenalidadSeCreaConOpcionesCorrectasEIncorrectasTest() {
        List<Opcion> opciones = new ArrayList<>();
        Opcion incorrecta1 = new ConPenalidad();
        Opcion incorrecta2 = new ConPenalidad();
        Opcion incorrecta3 = new ConPenalidad();
        Opcion correcta1 = new Correcta();
        Opcion correcta2 = new Correcta();
        opciones.add(incorrecta1);
        opciones.add(incorrecta2);
        opciones.add(incorrecta3);
        opciones.add(correcta1);
        opciones.add(correcta2);
        Pregunta pregunta = new MultipleChoiceConPenalidad(opciones, "Pregunta Test");
        assertEquals(2, pregunta.cantidadRespuestasCorrectas());
    }

    @Test
    public void preguntaMultipleChoiceConPenalidadPuntuaCorrectamenteAJugadorQueNoSeEquivocaTest() {
        List<Opcion> opciones = new ArrayList<>();
        Opcion incorrecta1 = new ConPenalidad();
        Opcion incorrecta2 = new ConPenalidad();
        Opcion incorrecta3 = new ConPenalidad();
        Opcion correcta1 = new Correcta();
        Opcion correcta2 = new Correcta();
        opciones.add(incorrecta1);
        opciones.add(incorrecta2);
        opciones.add(incorrecta3);
        opciones.add(correcta1);
        opciones.add(correcta2);
        Pregunta pregunta = new MultipleChoiceConPenalidad(opciones, "Pregunta Test");
        Jugador jugador = new Jugador("Maximus Decimus Meridius");
        List<Opcion> opcionesMarcadas = new ArrayList<>();
        opcionesMarcadas.add(correcta1);
        opcionesMarcadas.add(correcta2);
        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(opcionesMarcadas, jugador, new Multiplicador(1)));
        pregunta.evaluarRespuestas(respuestas);
        assertEquals(2, jugador.getPuntaje());
    }

    @Test
    public void preguntaMultipleChoiceConPenalidadPuntuaCorrectamenteAJugadorQueSeEquivocaTest() {
        List<Opcion> opciones = new ArrayList<>();
        Opcion incorrecta1 = new ConPenalidad();
        Opcion incorrecta2 = new ConPenalidad();
        Opcion incorrecta3 = new ConPenalidad();
        Opcion correcta1 = new Correcta();
        Opcion correcta2 = new Correcta();
        opciones.add(incorrecta1);
        opciones.add(incorrecta2);
        opciones.add(incorrecta3);
        opciones.add(correcta1);
        opciones.add(correcta2);
        Pregunta pregunta = new MultipleChoiceConPenalidad(opciones, "Pregunta Test");
        Jugador jugador = new Jugador("Maximus Decimus Meridius");
        List<Opcion> opcionesMarcadas = new ArrayList<>();
        opcionesMarcadas.add(incorrecta1);
        opcionesMarcadas.add(incorrecta2);
        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(opcionesMarcadas, jugador, new Multiplicador(1)));
        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-2, jugador.getPuntaje());
    }
}

