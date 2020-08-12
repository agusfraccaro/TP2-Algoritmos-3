package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Kahoot {
    private Ronda ronda;
    private List<Jugador> jugadores;
    private List<Pregunta> preguntas;
    private Iterator<Pregunta> iteradorPreguntas;
    private Pregunta preguntaActual;

    public Kahoot() {
        jugadores = new ArrayList<Jugador>();
        preguntas = new ArrayList<Pregunta>();
    }

    private Pregunta getSiguientePregunta(){
        if(iteradorPreguntas.hasNext()){
            preguntaActual = iteradorPreguntas.next();
        }

        return preguntaActual;
    }

    public Pregunta getPreguntaActual() {
        return preguntaActual;
    }

    public void cargarPreguntas() {
        //Aca se leen las preguntas dsd XML
        iteradorPreguntas = preguntas.iterator();
    }

    public void iniciarRonda() {
        ronda = new Ronda (jugadores, getSiguientePregunta());
    }

    public void registrarPregunta(Pregunta pregunta) {
        preguntas.add(pregunta);
    }


    public void registrarJugador(String nombre) {
        Jugador jugador = new Jugador(nombre);
        this.jugadores.add(jugador);
    }

    public String getJugadorActual() {
        return ronda.getJugadorActual().getNombre();
    }

    public List<Jugador> getJugadores() {
        return this.jugadores;
    }

    public void enviarRespuesta(List<Opcion> opciones, int extra) {
        ronda.enviarRespuesta(opciones, extra);
    }

}
