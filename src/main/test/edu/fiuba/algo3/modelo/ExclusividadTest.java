package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadTest {

    @Test
    public void ExclusividadNoHaceNadaSiSeInicializaConUnoUno(){
        Exclusividad excl = new Exclusividad(new int[]{1,1});
        List<Opcion> opciones = new ArrayList<>();
        List<Respuesta> respuestas = new ArrayList<>();
        Respuesta respuesta1 = new Respuesta(opciones, new Jugador("Flash"));
        Respuesta respuesta2 = new Respuesta(opciones, new Jugador("Aquaman"));
        respuesta1.sumarPuntos(5);
        respuesta2.sumarPuntos(7);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        excl.aplicarBonus(respuestas);
        assertEquals(respuesta1.getPuntos(), 5);
        assertEquals(respuesta2.getPuntos(), 7);
    }


    @Test
    public void ExclusividadMultiplicaCorrectamenteCuandoJugadorActivaYPierde(){
        Exclusividad excl = new Exclusividad(new int[]{2,1});
        List<Opcion> opciones = new ArrayList<>();
        List<Respuesta> respuestas = new ArrayList<>();
        Respuesta respuesta1 = new Respuesta(opciones, new Jugador("Flash"));
        Respuesta respuesta2 = new Respuesta(opciones, new Jugador("Aquaman"));
        respuesta1.sumarPuntos(5);
        respuesta2.sumarPuntos(7);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        excl.aplicarBonus(respuestas);
        assertEquals(respuesta1.getPuntos(), 5);
        assertEquals(respuesta2.getPuntos(), 14);
    }

    @Test
    public void ExclusividadMultiplicaCorrectamenteCuandoJugadorActivaYGana(){
        Exclusividad excl = new Exclusividad(new int[]{1,2});
        List<Opcion> opciones = new ArrayList<>();
        List<Respuesta> respuestas = new ArrayList<>();
        Respuesta respuesta1 = new Respuesta(opciones, new Jugador("Flash"));
        Respuesta respuesta2 = new Respuesta(opciones, new Jugador("Aquaman"));
        respuesta1.sumarPuntos(5);
        respuesta2.sumarPuntos(7);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        excl.aplicarBonus(respuestas);
        assertEquals(respuesta1.getPuntos(), 5);
        assertEquals(respuesta2.getPuntos(), 14);
    }

    @Test
    public void ExclusividadMultiplicaCorrectamenteCuandoAmbosJugadoresActivan(){
        Exclusividad excl = new Exclusividad(new int[]{2,2});
        List<Opcion> opciones = new ArrayList<>();
        List<Respuesta> respuestas = new ArrayList<>();
        Respuesta respuesta1 = new Respuesta(opciones, new Jugador("Flash"));
        Respuesta respuesta2 = new Respuesta(opciones, new Jugador("Aquaman"));
        respuesta1.sumarPuntos(5);
        respuesta2.sumarPuntos(7);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        excl.aplicarBonus(respuestas);
        assertEquals(respuesta1.getPuntos(), 5);
        assertEquals(respuesta2.getPuntos(), 28);
    }
}