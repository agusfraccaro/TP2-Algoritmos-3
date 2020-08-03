package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class giRonda {
    private Jugador jugadorActual;
    private List<Respuesta> respuestas;
    private List<Jugador> jugadores;
    private Pregunta pregunta;
    private Iterator<Jugador> iterador;

    public Ronda (List<Jugador> jugadores, Pregunta pregunta){
        this.jugadores = jugadores;
        this.pregunta = pregunta;
        iterador = jugadores.iterator();
        jugadorActual = iterador.next();
        respuestas = new ArrayList<Respuesta>();
    }

    private void siguienteJugador(){
        if(iterador.hasNext()){
            jugadorActual = iterador.next();
        }
    }

    public void evaluar(){
        pregunta.evaluarRespuestas(respuestas);
    }

    public void enviarRespuesta(List<Opcion> opciones,Multiplicador multiplicador) {
        Respuesta respuesta = new Respuesta(opciones,jugadorActual,multiplicador);
        respuestas.add(respuesta);
    }

    public Jugador getJugadorActual(){
        return jugadorActual;
    }

}
