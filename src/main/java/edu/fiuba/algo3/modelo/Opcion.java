package edu.fiuba.algo3.modelo;

public abstract class Opcion {
    protected String texto;
    abstract int puntuar();
    abstract boolean esCorrecta();

    //TODO Agregar constructor con texto.
    public boolean equalsTo(Opcion opcion){
        return this.getTexto().equals(opcion.getTexto());
    }

    public String getTexto(){
        return this.texto;
    }

}
