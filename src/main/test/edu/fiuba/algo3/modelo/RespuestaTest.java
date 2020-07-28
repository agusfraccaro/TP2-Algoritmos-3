package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.nio.charset.CoderResult;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
    public void respuestaMultilplicaX2Correctamente(){
        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Correcta());
        opciones.add(new SinPenalidad());

        Respuesta respuesta = new Respuesta(opciones, new Jugador("unJugador"), new Multiplicador(2));

        respuesta.sumarPuntos(respuesta.aplicarMultiplicador(8));

        assertEquals(respuesta.getJugador().getPuntaje() , 16);
    }
}
