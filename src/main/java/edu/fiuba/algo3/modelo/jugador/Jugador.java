package edu.fiuba.algo3.modelo.jugador;

public class Jugador {
    private int puntaje = 0;
    private String nombre;

    public Jugador(String nombre){
        this.nombre = nombre;
    }

    public void sumarPuntos(int puntos){
        this.puntaje += puntos;
    }

    public int getPuntaje(){
        return this.puntaje;
    }

    public String getNombre(){
        return nombre;
    }
}
