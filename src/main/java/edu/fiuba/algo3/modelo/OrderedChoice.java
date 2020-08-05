package edu.fiuba.algo3.modelo;

import java.util.List;

public class OrderedChoice extends Pregunta {

    public OrderedChoice(List <Opcion> opciones, String texto) {
        super(opciones, texto);
        this.puntuador = new Puntuador(new Exclusividad(new int[]{1,1}));
    }

    @Override
    public int puntuar(Respuesta respuesta) {
        List<Opcion> opcionesMarcadas = respuesta.getOpciones();
        for(int i = 0; i < opcionesMarcadas.size(); i++){
            if (!opcionesMarcadas.get(i).equalsTo(this.opciones.get(i))) {return 0;};
        }
        if (opcionesMarcadas.size() != this.opciones.size()) {return 0;}
        return 1;
    }

    @Override
    public void activarBonus(int[] numeros) {
        this.puntuador = new Puntuador(new Exclusividad(numeros));
    }
}
