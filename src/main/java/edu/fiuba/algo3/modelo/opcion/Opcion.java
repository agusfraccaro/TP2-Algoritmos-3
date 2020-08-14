package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.excepciones.EstadoNuloNoEsIncorrectoNiCorrectoExcepcion;
import edu.fiuba.algo3.modelo.excepciones.EstadoNuloNoPuntuaExcepcion;

public class Opcion {
    private String texto;
    private EstadoOpcion estado;
    private String grupo;

    //para las que son Correcta o Incorrecta (no tienen grupo)
    public Opcion(String texto, EstadoOpcion estado){
        this.texto = texto;
        this.estado = estado;
        this.grupo = null;
    }

    //para las GroupChoice
    public Opcion(String texto, String grupo){
        this.texto = texto;
        this.grupo = grupo;
        this.estado = new EstadoNulo();
    }

    //para las OrderedChoice
    public Opcion(String texto){
        this.texto = texto;
        this.estado = new EstadoNulo();
        this.grupo = null;
    }

    public int puntuar(){
        int puntos = 0;
        try{
            puntos = this.estado.puntuar();
        } catch (EstadoNuloNoPuntuaExcepcion estadoNuloNoPuntuaExcepcion){}

        return puntos;
    }

    public boolean esCorrecta(){
        boolean estado = false;
        try{
            estado = this.estado.esCorrecta();
        }catch (EstadoNuloNoEsIncorrectoNiCorrectoExcepcion estadoNuloNoEsIncorrectoNiCorrectoExcepcion){}

        return estado;
    }

    public String getTexto(){
        return this.texto;
    }

    public String getGrupo(){
        return this.grupo;
    }

    @Override
    public boolean equals(Object objeto) {
        if (objeto == null || (objeto.getClass() != this.getClass())){
            return false;
        }
        if (this == objeto){
            return true;
        }
        Opcion opcion = (Opcion)objeto;
        return ((this.grupo == null || this.grupo.equals(opcion.getGrupo())) && this.texto.equals(opcion.getTexto()));
    }
}
