package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RespuestaTest {

    @Test
    public void respuestaSeCreaConDosOpcionesTest(){
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("A"));
        opciones.add(new SinPenalidad("B"));

        Respuesta respuesta = new Respuesta(opciones, new Jugador("unJugador"));

        assertEquals((respuesta.getOpciones()).size(), 2);
    }
    @Test
    public void respuestaSeCreaConUnJugadorTest() {
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("A"));
        opciones.add(new SinPenalidad("B"));

        Respuesta respuesta = new Respuesta(opciones, new Jugador("unJugador"));


        assertEquals(respuesta.getJugador().getNombre() , "unJugador");
    }

    @Test
    public void respuestaSumaPuntosCorrectamenteTest(){
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("A"));
        opciones.add(new SinPenalidad("B"));

        Respuesta respuesta = new Respuesta(opciones, new Jugador("unJugador"));

        respuesta.sumarPuntos(6);
        respuesta.aplicarPuntos();

        assertEquals(respuesta.getJugador().getPuntaje() , 6);
    }

    @Test
    public void respuestaDevuelveTrueSiTodasLasOpcionesSonCorrectas(){
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("A"));
        opciones.add(new Correcta("B"));
        opciones.add(new Correcta("C"));
        Respuesta respuesta = new Respuesta(opciones, new Jugador("Batman"));

        assertTrue(respuesta.todasLasOpcionesMarcadasSonCorrectas());
    }

    @Test
    public void respuestaDevuelveFalseSiNingunaOpcionEsCorrecta(){
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new SinPenalidad("A"));
        opciones.add(new ConPenalidad("B"));
        opciones.add(new ConPenalidad("C"));
        Respuesta respuesta = new Respuesta(opciones, new Jugador("Donald Trump"));

        assertFalse(respuesta.todasLasOpcionesMarcadasSonCorrectas());
    }

    @Test
    public void respuestaDevuelveFalseSiAlgunaOpcionEsIncorrecta(){
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("A"));
        opciones.add(new SinPenalidad("B"));
        opciones.add(new ConPenalidad("C"));
        Respuesta respuesta = new Respuesta(opciones, new Jugador("Ricardo Fort"));

        assertFalse(respuesta.todasLasOpcionesMarcadasSonCorrectas());
    }

}
