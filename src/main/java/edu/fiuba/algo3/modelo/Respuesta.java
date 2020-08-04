package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Respuesta {
    private List<Opcion> opcionesMarcadas;
    private Jugador jugador;
    private int multiplicador;
    private int puntos = 0;

    public Respuesta(List<Opcion> opciones, Jugador jugadorActual) {
        this(opciones, jugadorActual, 1);
    }
    public Respuesta(List<Opcion> opciones, Jugador jugadorActual, int multiplicador) {
        opcionesMarcadas = opciones;
        jugador = jugadorActual;
        this.multiplicador = multiplicador;
    }

    public List<Opcion> getOpciones(){
        return this.opcionesMarcadas;
    }

    public Jugador getJugador() {return jugador; }

    public void aplicarMultiplicador() {
        this.puntos *= this.multiplicador;
    }

    public void aplicarExclusividad(int factor) {
        this.puntos *= factor;
    }

    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
        //jugador.sumarPuntos(puntos);
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
