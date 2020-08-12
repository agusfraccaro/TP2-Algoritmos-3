package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;

import java.util.List;

public class Respuesta {
    private List<Opcion> opcionesMarcadas;
    private Jugador jugador;
    private int puntos = 0;

    public Respuesta(List<Opcion> opciones, Jugador jugador) {
        opcionesMarcadas = opciones;
        this.jugador = jugador;
    }

    public List<Opcion> getOpciones(){
        return this.opcionesMarcadas;
    }

    public Jugador getJugador() { return jugador; }

    public int getPuntos() { return this.puntos; }

    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public void multiplicarPuntos(int factor) { this.puntos *= factor; }

    public void aplicarPuntos() {
        jugador.sumarPuntos(this.puntos);
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
