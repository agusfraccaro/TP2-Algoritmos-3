package edu.fiuba.algo3.modelo;

import java.util.List;

public class OrderedChoice extends Pregunta {

    public OrderedChoice(List <Opcion> opciones, String texto) {
        super(opciones, texto);
        this.puntuador = new Puntuador(new Exclusividad(new int[]{1,1}));
    }

    @Override
    public int puntuar(Respuesta respuesta) {
        if(opciones.equals(respuesta.getOpciones())){
            return 1;
        }
        return 0;
    }

    @Override
    public void activarBonus(int[] numeros) {
        this.puntuador = new Puntuador(new Exclusividad(numeros));
    }
}
