package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderedChoiceTest {

    /*@Test
    public void preguntaOrderedChoicePuntuaCorrectamenteSiJugadoresOrdenanBien(){
        OpcionA opcion1 = new OpcionA();
        OpcionA opcion2 = new OpcionA();
        OpcionA opcion3 = new OpcionA();
        List<Opcion> opciones = new ArrayList<>(){
            {add(opcion1); add(opcion2); add(opcion3);};
        };

        Pregunta orderedChoice = new OrderedChoice(opciones, "De que color es el caballo blanco de San Martin");

        Jugador jugador1 = new Jugador("Camila");
        List<Opcion> opcionesMarcadas1 = new ArrayList<Opcion>() {
            {add(opcion1); add(opcion2); add(opcion3);}
        };

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1));
        orderedChoice.evaluarRespuestas(respuestas);

        assertEquals(jugador1.getPuntaje(), 1);
    }

    @Test
    public void preguntaOrderedChoicePuntuaCorrectamenteSiJugadoresOrdenanMal(){
        OpcionA opcion1 = new OpcionA();
        OpcionA opcion2 = new OpcionA();
        OpcionA opcion3 = new OpcionA();
        List<Opcion> opciones = new ArrayList<>(){
            {add(opcion1); add(opcion2); add(opcion3);};
        };

        Pregunta orderedChoice = new OrderedChoice(opciones, "De que color es el caballo negro de San Martin");

        Jugador jugador1 = new Jugador("AgusF");
        List<Opcion> opcionesMarcadas1 = new ArrayList<Opcion>() {
            {add(opcion1); add(opcion3); add(opcion2);}
        };

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(opcionesMarcadas1, jugador1));
        orderedChoice.evaluarRespuestas(respuestas);

        assertEquals(jugador1.getPuntaje(), 0);
    }*/
}
