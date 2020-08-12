package edu.fiuba.algo3.modelo.opcion;

public class Opcion {
    private String texto;
    private EstadoOpcion estado;
    private String grupo;

    //para las que son Correcta o Incorrecta (no tienen grupo)
    public Opcion(String texto, EstadoOpcion estado){
        this.texto = texto;
        this.estado = estado;
    }

    //para las GroupChoice
    public Opcion(String texto, String grupo){
        this.texto = texto;
        this.grupo = grupo;
    }

    //para las OrderedChoice
    public Opcion(String texto){
        this.texto = texto;
    }

    public int puntuar(){
        return this.estado.puntuar();
    }

    public boolean esCorrecta(){
        return this.estado.esCorrecta();
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
