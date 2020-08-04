package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Respuesta {
    private List<Opcion> opcionesMarcadas;
    private Jugador jugador;
    private Multiplicador multiplicador;
    private int puntos = 0;

    public Respuesta(List<Opcion> opciones, Jugador jugadorActual) {
        this(opciones, jugadorActual, new Multiplicador(1));
    }
    public Respuesta(List<Opcion> opciones, Jugador jugadorActual, Multiplicador multiplicador) {
        opcionesMarcadas = opciones;
        jugador = jugadorActual;
        this.multiplicador = multiplicador;
    }

    public List<Opcion> getOpciones(){
        return this.opcionesMarcadas;
    }

    public Jugador getJugador() {return jugador; }

    public void aplicarMultiplicador() {
        this.multiplicador.multiplicar(this.puntos);
    }

    public void aplicarExclusividad(int factor) {
        this.puntos *= factor;
    }

    //Tal vez hay forma de unir aplicarMultiplicador y Exclusividad en 1 metodo
    //public void multiplicarPuntos(int factor) { this.puntos *= factor; }

    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public void aplicarPuntos() {
        jugador.sumarPuntos(this.puntos);
    }

    public boolean esCorrecta() {
        return this.puntos == 1;
    }

    public boolean todasLasOpcionesMarcadasSonCorrectas() {
        for(Opcion opcion: opcionesMarcadas){
            if(!opcion.esCorrecta()){
                return false;
            }
        }
        return true;
    }
}
