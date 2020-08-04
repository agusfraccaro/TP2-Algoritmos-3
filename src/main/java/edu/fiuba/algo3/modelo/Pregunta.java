package edu.fiuba.algo3.modelo;

import java.util.List;

public abstract class Pregunta {
    protected String texto;
    protected List<Opcion> opciones;
    protected Puntuador puntuador;

    public Pregunta(List<Opcion> opciones, String texto) {
        this.texto = texto;
        this.opciones = opciones;
        puntuador = new PuntuadorClasico(); //FIXME cada tipo de pregunta usa su propio puntuador
    }

    public void evaluarRespuestas(List<Respuesta> respuestas) {
        puntuador.puntuar(respuestas, this);
    }

    public abstract int puntuar(Respuesta respuesta);

    public int cantidadRespuestasCorrectas(){
        int cantidad = 0;
        for(Opcion opcion: this.opciones){
            if(opcion.esCorrecta()){
                cantidad++;
            }
        }
        return cantidad;
    }

    public abstract void activarExclusividad(int factorExclusividad); //TODO Delegar a cada subclase si tira error o delega al puntuador
}
