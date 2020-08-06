package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoiceParcial extends Pregunta {

    public MultipleChoiceParcial(List<Opcion> opciones, String texto) {
        super(opciones, texto);
        this.puntuador = new Puntuador(new Exclusividad(new int[]{1,1}));

    }

    @Override
    public int puntuar(Respuesta respuesta) {
        if (respuesta.todasLasOpcionesMarcadasSonCorrectas()) {
            return respuesta.getOpciones().size();
        }
        return 0;
    }

    @Override
    public void activarBonus(int[] numeros) {
        this.puntuador = new Puntuador(new Exclusividad(numeros));
    }
}