package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Respuesta {
    private List<Opcion> opcionesMarcadas;
    private Jugador jugador;
    private Multiplicador multiplicador;

    public Respuesta(List<Opcion> opciones, Jugador jugadorActual, Multiplicador multiplicador) {
        opcionesMarcadas = opciones;
        jugador = jugadorActual;
        this.multiplicador = multiplicador;
    }

    public List<Opcion> getOpciones(){
        return this.opcionesMarcadas;
    }

    public Jugador getJugador() {return jugador; }

    public int aplicarMultiplicador(int puntos) {
        return multiplicador.multiplicar(puntos);
    }

    public void sumarPuntos(int puntos) {
        jugador.sumarPuntos(puntos);
    }

    public boolean esCorrecta() {
        for(Opcion opcion: opcionesMarcadas){
            if(!opcion.esCorrecta()){
                return false;
            }
        }
        return true;
    }
}
