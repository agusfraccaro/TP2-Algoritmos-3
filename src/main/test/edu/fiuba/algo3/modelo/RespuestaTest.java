package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.nio.charset.CoderResult;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RespuestaTest {
    static int CANTIDAD_MULTIPLICAR = 1;

    @Test
    public void respuestaSeCreaConDosOpcionesTest(){
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("opcion1", new Correcta()));
        opciones.add(new Opcion("opcion2", new SinPenalidad()));

        Respuesta respuesta = new Respuesta(opciones, new Jugador("unJugador"), new Multiplicador(CANTIDAD_MULTIPLICAR));

        assertEquals((respuesta.getOpciones()).size(), 2);
    }
    @Test
    public void respuestaSeCreaConUnJugadorTest() {
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("opcion1", new Correcta()));
        opciones.add(new Opcion("opcion2", new SinPenalidad()));

        Respuesta respuesta = new Respuesta(opciones, new Jugador("unJugador"), new Multiplicador(CANTIDAD_MULTIPLICAR));


        assertEquals(respuesta.getJugador().getNombre() , "unJugador");
    }

    @Test
    public void respuestaSumaPuntosCorrectamenteTest(){
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("opcion1", new Correcta()));
        opciones.add(new Opcion("opcion2", new SinPenalidad()));

        Respuesta respuesta = new Respuesta(opciones, new Jugador("unJugador"), new Multiplicador(CANTIDAD_MULTIPLICAR));

        respuesta.sumarPuntos(6);
        respuesta.aplicarPuntos();

        assertEquals(respuesta.getJugador().getPuntaje() , 6);
    }

    @Test
    public void respuestaDevuelveTrueSiTodasLasOpcionesSonCorrectas(){
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Opcion("opcion1", new Correcta()));
        opciones.add(new Opcion("opcion2", new Correcta()));
        opciones.add(new Opcion("opcion3", new Correcta()));
        Respuesta respuesta = new Respuesta(opciones, new Jugador("Batman"));

        assertTrue(respuesta.todasLasOpcionesMarcadasSonCorrectas());
    }

    @Test
    public void respuestaDevuelveFalseSiNingunaOpcionEsCorrecta(){
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Opcion("opcion1", new SinPenalidad()));
        opciones.add(new Opcion("opcion2", new ConPenalidad()));
        opciones.add(new Opcion("opcion3", new ConPenalidad()));
        Respuesta respuesta = new Respuesta(opciones, new Jugador("Donald Trump"));

        assertFalse(respuesta.todasLasOpcionesMarcadasSonCorrectas());
    }

    @Test
    public void respuestaDevuelveFalseSiAlgunaOpcionEsIncorrecta(){
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Opcion("opcion1", new Correcta()));
        opciones.add(new Opcion("opcion2", new SinPenalidad()));
        opciones.add(new Opcion("opcion3", new ConPenalidad()));
        Respuesta respuesta = new Respuesta(opciones, new Jugador("Ricardo Fort"));

        assertFalse(respuesta.todasLasOpcionesMarcadasSonCorrectas());
    }

}
