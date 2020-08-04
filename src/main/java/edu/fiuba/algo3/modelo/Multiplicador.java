package edu.fiuba.algo3.modelo;

//import java.util.List;

//Tal vez se puede hacer que implemente a Bonus
public class Multiplicador {
    private int cantidadAMultiplicar;

    public Multiplicador(int cantidadAMultiplicar){
        this.cantidadAMultiplicar = cantidadAMultiplicar;
    }

    public int multiplicar(int puntos) {
        return cantidadAMultiplicar * puntos;
    }

    /*public void aplicarBonus(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            respuesta.multiplicarPuntos();
        }
    }*/
}
