package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Kahoot {
    private Ronda ronda;
    private List<Jugador> jugadores;
    private List<Pregunta> preguntas;

    public Kahoot() {
        jugadores = new ArrayList<Jugador>();
        preguntas = new ArrayList<Pregunta>();
    }

    public void cargarPreguntas() {
        //Aca se leen las preguntas dsd XML
    }

    public void registrarPregunta(Pregunta pregunta) {
        preguntas.add(pregunta);
    }


    public void registrarJugador(String nombre) {
        Jugador jugador = new Jugador(nombre);
        this.jugadores.add(jugador);
    }

    public List<Jugador> getJugadores() {
        return this.jugadores;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void enviarRespuesta(List<Opcion> opciones, int extra) {
        ronda.enviarRespuesta(opciones, extra);
    }

}
