package edu.fiuba.algo3.modelo.kahoot;

import edu.fiuba.algo3.modelo.excepciones.NoHaySiguientePreguntaExcepcion;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.ronda.Ronda;

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

    private Pregunta getSiguientePregunta() throws NoHaySiguientePreguntaExcepcion {
        if(iteradorPreguntas.hasNext()){
            preguntaActual = iteradorPreguntas.next();
            return preguntaActual;
        }
        throw new NoHaySiguientePreguntaExcepcion();
    }

    public Pregunta getPreguntaActual() {
        return preguntaActual;
    }

    public void cargarPreguntas() {
        //Aca se leen las preguntas dsd XML
        iteradorPreguntas = preguntas.iterator();
    }

    public void iniciarRonda() throws NoHaySiguientePreguntaExcepcion {
        try{
            ronda = new Ronda (jugadores, getSiguientePregunta());
        }catch (NoHaySiguientePreguntaExcepcion excepcion){
            throw excepcion;
        }
    }

    public void registrarPregunta(Pregunta pregunta) {
        preguntas.add(pregunta);
    }


    public void registrarJugador(String nombre) {
        Jugador jugador = new Jugador(nombre);
        this.jugadores.add(jugador);
    }

    public Jugador getJugadorActual() {
        return ronda.getJugadorActual();
    }

    public List<Jugador> getJugadores() {
        return this.jugadores;
    }

    public void enviarRespuesta(List<Opcion> opciones, int extra) {
        ronda.enviarRespuesta(opciones, extra);
    }

    public Jugador getGanador(){
        if(jugadores.get(0).getPuntaje() > jugadores.get(1).getPuntaje()){
            return jugadores.get(0);
        }
        return jugadores.get(1);
    }
}
