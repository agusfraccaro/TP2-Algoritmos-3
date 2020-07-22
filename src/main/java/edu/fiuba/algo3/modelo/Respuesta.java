package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Respuesta {
    private ArrayList<Opcion> opcionesMarcadas = new ArrayList<Opcion>();

    public ArrayList getOpciones(){
        return this.opcionesMarcadas;
    }

    public void marcarOpcion(Opcion unaOpcion){
        opcionesMarcadas.add(unaOpcion);
    }

}
