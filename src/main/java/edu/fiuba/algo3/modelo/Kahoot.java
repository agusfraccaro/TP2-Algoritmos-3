package edu.fiuba.algo3.modelo;

import java.util.List;

public class Kahoot {
    private Ronda ronda;
    private List<Jugador> jugadores;
    private List<Pregunta> preguntas;

    public Kahoot() {
    }

    public void cargarPreguntas() {
        //Aca se leen las preguntas dsd XML
    }

    public void registrarPregunta(Pregunta pregunta) {
        preguntas.add(pregunta);
    }


    public void registrarJugador(String nombre) {
        Jugador jugador = new Jugador(nombre);
        jugadores.add(jugador);
    }

    public void enviarRespuesta(List<Opcion> opciones,Multiplicador multiplicador) {
        ronda.enviarRespuesta(opciones,multiplicador);
    }

}
