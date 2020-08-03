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
        opciones.add(new Correcta());
        opciones.add(new SinPenalidad());

        Respuesta respuesta = new Respuesta(opciones, new Jugador("unJugador"), new Multiplicador(CANTIDAD_MULTIPLICAR));

        assertEquals((respuesta.getOpciones()).size(), 2);
    }
    @Test
    public void respuestaSeCreaConUnJugadorTest() {
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Correcta());
        opciones.add(new SinPenalidad());

        Respuesta respuesta = new Respuesta(opciones, new Jugador("unJugador"), new Multiplicador(CANTIDAD_MULTIPLICAR));


        assertEquals(respuesta.getJugador().getNombre() , "unJugador");
    }

    @Test
    public void respuestaSumaPuntosCorrectamenteTest(){
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Correcta());
        opciones.add(new SinPenalidad());

        Respuesta respuesta = new Respuesta(opciones, new Jugador("unJugador"), new Multiplicador(CANTIDAD_MULTIPLICAR));

        respuesta.sumarPuntos(6);

        assertEquals(respuesta.getJugador().getPuntaje() , 6);
    }

    @Test
    public void respuestaMultiplicaX1PorDefaultTest(){
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta());
        opciones.add(new SinPenalidad());
        Respuesta respuesta = new Respuesta(opciones, new Jugador("Carlitos Mi Tio"));

        int puntos = respuesta.aplicarMultiplicador(5);

        assertEquals(puntos, 5);
    }

    @Test
    public void respuestaMultilplicaX2CorrectamenteTest(){
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Correcta());
        opciones.add(new SinPenalidad());
        Respuesta respuesta = new Respuesta(opciones, new Jugador("unJugador"), new Multiplicador(2));

        int puntos = respuesta.aplicarMultiplicador(8);

        assertEquals(puntos , 16);
    }

    @Test
    public void respuestaDevuelveTrueSiTodasLasOpcionesSonCorrectas(){
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta());
        opciones.add(new Correcta());
        opciones.add(new Correcta());
        Respuesta respuesta = new Respuesta(opciones, new Jugador("Batman"));

        assertTrue(respuesta.todasLasOpcionesMarcadasSonCorrectas());
    }

    @Test
    public void respuestaDevuelveFalseSiNingunaOpcionEsCorrecta(){
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new SinPenalidad());
        opciones.add(new ConPenalidad());
        opciones.add(new ConPenalidad());
        Respuesta respuesta = new Respuesta(opciones, new Jugador("Donald Trump"));

        assertFalse(respuesta.todasLasOpcionesMarcadasSonCorrectas());
    }

    @Test
    public void respuestaDevuelveFalseSiAlgunaOpcionEsIncorrecta(){
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta());
        opciones.add(new SinPenalidad());
        opciones.add(new ConPenalidad());
        Respuesta respuesta = new Respuesta(opciones, new Jugador("Ricardo Fort"));

        assertFalse(respuesta.todasLasOpcionesMarcadasSonCorrectas());
    }

}
