package edu.fiuba.algo3.modelo.jugador;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private int puntaje = 0;
    private final String nombre;
    private final List<BONUS> bonus = new ArrayList<>();

    public Jugador(String nombre){
        this.nombre = nombre;
        this.bonus.add(BONUS.EXCLUSIVIDAD);
        this.bonus.add(BONUS.EXCLUSIVIDAD);
        this.bonus.add(BONUS.X2);
        this.bonus.add(BONUS.X3);
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

    public boolean puedeAplicarMultiplicadorPor2() {
        return bonus.contains(BONUS.X2);
    }

    public boolean puedeAplicarMultiplicadorPor3() {
        return bonus.contains(BONUS.X3);
    }

    public boolean puedeAplicarExclusividad() {
        return bonus.contains(BONUS.EXCLUSIVIDAD);
    }

    public void gastarBonus(BONUS bonusGastado) {
        bonus.remove(bonusGastado);
    }
}
