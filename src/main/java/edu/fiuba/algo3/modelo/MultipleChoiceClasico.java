package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoiceClasico extends Pregunta {

    public MultipleChoiceClasico(List <Opcion> opciones, String texto) {
        super(opciones, texto);
        this.puntuador = new Puntuador(new Exclusividad(new int[]{1,1}));
    }

    @Override
    public int puntuar(Respuesta respuesta) {
        int puntos = 0;
        for(Opcion opcion: respuesta.getOpciones()){
            puntos += opcion.puntuar();
        }
        if(puntos == this.cantidadRespuestasCorrectas() && respuesta.todasLasOpcionesMarcadasSonCorrectas()){
            return 1;
        }
        return 0;
    }

    @Override
    public void activarBonus(int[] numeros) {
        this.puntuador = new Puntuador(new Exclusividad(numeros));
    }
}