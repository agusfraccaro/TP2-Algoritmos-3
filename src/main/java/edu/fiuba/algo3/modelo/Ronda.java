package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Ronda {
    private Jugador jugadorActual;
    private Respuesta respuestaActual;
    private ArrayList<Jugador> jugadores;
    private Pregunta pregunta;
    private Iterator<Jugador> iterador;

    public Ronda (ArrayList<Jugador> jugadores, Pregunta pregunta){
        this.jugadores = jugadores;
        this.pregunta = pregunta;
        iterador = jugadores.iterator();
        jugadorActual = iterador.next();
        respuestaActual = new Respuesta();
    }

    public void marcarOpcion(Opcion opcion){
        respuestaActual.marcarOpcion(opcion);
    }

    public void siguienteJugador(){
        if(iterador.hasNext()){
            jugadorActual = iterador.next();
        }else{
            iterador = jugadores.iterator();
            jugadorActual = iterador.next();
        }
        respuestaActual = new Respuesta();
    }

    public void evaluar(){
        int puntos = pregunta.evaluarRespuestas(respuestaActual);
        jugadorActual.sumarPuntos(puntos);
    }

    public Jugador getJugadorActual(){
        return jugadorActual;
    }

}
