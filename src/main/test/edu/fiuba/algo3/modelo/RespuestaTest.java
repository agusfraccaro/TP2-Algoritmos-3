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
    public void respuestaSeCreaConUnMultiplicadorTest() {
        assertEquals(2,1);
    }

    @Test
    public void respuestaSumaPuntosCorrectamenteTest()
    {
        assertEquals(2,1);
    }
}
