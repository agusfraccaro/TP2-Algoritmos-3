package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicadorTest {

    @Test
    public void MultiplicadorNoHaceNadaSiSeInicializaConUnoUno(){
        Multiplicador mult= new Multiplicador(new int[]{1,1});
        List<Opcion> opciones = new ArrayList<>();
        List<Respuesta> respuestas = new ArrayList<>();
        Respuesta respuesta1 = new Respuesta(opciones, new Jugador("Flash"));
        Respuesta respuesta2 = new Respuesta(opciones, new Jugador("Aquaman"));
        respuesta1.sumarPuntos(5);
        respuesta2.sumarPuntos(7);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        mult.aplicarBonus(respuestas);
        assertEquals(respuesta1.getPuntos(), 5);
        assertEquals(respuesta2.getPuntos(), 7);
    }

    @Test
    public void multiplicadorMultiplicaCorrectamente(){
        Multiplicador mult = new Multiplicador(new int[]{2,3});
        List<Opcion> opciones = new ArrayList<>();
        List<Respuesta> respuestas = new ArrayList<>();
        Respuesta respuesta1 = new Respuesta(opciones, new Jugador("Flash"));
        Respuesta respuesta2 = new Respuesta(opciones, new Jugador("Aquaman"));
        respuesta1.sumarPuntos(5);
        respuesta2.sumarPuntos(7);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        mult.aplicarBonus(respuestas);
        assertEquals(respuesta1.getPuntos(), 10);
        assertEquals(respuesta2.getPuntos(), 21);
    }
}
