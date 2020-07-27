package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ronda {
    private Jugador jugadorActual;
    private List<Respuesta> respuestas;
    private ArrayList<Jugador> jugadores;
    private Pregunta pregunta;
    private Iterator<Jugador> iterador;
    private Respuesta respuestaActual;

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

    private void siguienteJugador(){
        if(iterador.hasNext()){
            jugadorActual = iterador.next();
        }
        respuestaActual = new Respuesta();
    }

    public void guardarRespuesta() {
        respuestas.add(respuestaActual);
    }

    public void evaluar(){
        for (Respuesta respuesta : respuestas) {
            int puntos = pregunta.evaluarRespuestas(respuesta);
            //TODO Agregar puntuador
            jugadorActual.sumarPuntos(puntos);
        }
    }

    public Jugador getJugadorActual(){
        return jugadorActual;
    }

}
