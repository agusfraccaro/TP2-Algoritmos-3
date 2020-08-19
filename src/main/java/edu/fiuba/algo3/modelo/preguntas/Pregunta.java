package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.preguntas.puntuador.Puntuador;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.List;

public abstract class Pregunta {
    protected String texto;
    protected List<Opcion> opciones;
    protected Puntuador puntuador;

    public Pregunta(List<Opcion> opciones, String texto) {
        this.texto = texto;
        this.opciones = opciones;
    }
    public String getTexto() {
        return texto;
    }

    public void evaluarRespuestas(List<Respuesta> respuestas) {
        puntuador.puntuar(respuestas, this);
    }

    public abstract int puntuar(Respuesta respuesta);

    public int cantidadOpcionesCorrectas(){
        int cantidad = 0;
        for(Opcion opcion: this.opciones){
            if(opcion.esCorrecta()){
                cantidad++;
            }
        }
        return cantidad;
    }

    public abstract void activarBonus(List<Integer> numeros);

    public List<Opcion> getOpciones() {
        return opciones;
    }
}
