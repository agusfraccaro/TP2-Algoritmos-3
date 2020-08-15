package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.excepciones.NoMarcoOpcionExcepcion;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.preguntas.puntuador.Exclusividad;
import edu.fiuba.algo3.modelo.preguntas.puntuador.Puntuador;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;

public class OrderedChoice extends Pregunta {

    public OrderedChoice(List <Opcion> opciones, String texto) {
        super(opciones, texto);
        this.puntuador = new Puntuador();
    }

    @Override
    public int puntuar(Respuesta respuesta) {
        try {
            if(opciones.equals(respuesta.getOpciones())){
                return 1;
            }
        }
        catch (NoMarcoOpcionExcepcion ex) {
            return 0;
        }

        return 0;
    }

    @Override
    public void activarBonus(ArrayList<Integer> numeros) {
        this.puntuador.activarBonus(new Exclusividad(numeros));
    }
}
