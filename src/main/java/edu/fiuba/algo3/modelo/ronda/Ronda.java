package edu.fiuba.algo3.modelo.ronda;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ronda {
    private Jugador jugadorActual;
    private List<Respuesta> respuestas = new ArrayList<>();
    private List<Jugador> jugadores;
    private List<Integer> extras = new ArrayList<>();
    private Pregunta pregunta;
    private Iterator<Jugador> iterador;

    public Ronda (List<Jugador> jugadores, Pregunta pregunta){
        this.jugadores = jugadores;
        this.pregunta = pregunta;
        iterador = jugadores.iterator();
        jugadorActual = iterador.next();
    }

    private void siguienteJugador(){
        jugadorActual = iterador.next();
    }

    private void evaluar(){
        pregunta.evaluarRespuestas(respuestas);
    }

    public void enviarRespuesta(List<Opcion> opciones, int extra) {
        Respuesta respuesta = new Respuesta(opciones,jugadorActual);
        respuestas.add(respuesta);
        extras.add(extra);
        if(iterador.hasNext()){
            siguienteJugador();
        }else{
            evaluar();
        }

    }

    public Jugador getJugadorActual(){
        return jugadorActual;
    }

}
