package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Respuesta {
    public ArrayList<Opcion> opcionesMarcadas = new ArrayList<Opcion>();
    public Jugador jugador;

    public Respuesta(Jugador jugador){
        this.jugador = jugador;
    }

    public ArrayList getOpciones(){
        return this.opcionesMarcadas;
    }

    public void marcarOpcion(Opcion unaOpcion){
        opcionesMarcadas.add(unaOpcion);
    }

    public void puntuar(int puntos){
        jugador.sumarPuntos(puntos);
    }
}
