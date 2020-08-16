package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.excepciones.NoMarcoOpcionExcepcion;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.preguntas.puntuador.Exclusividad;
import edu.fiuba.algo3.modelo.preguntas.puntuador.Puntuador;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.List;

public class MultipleChoiceClasico extends Pregunta {

    public MultipleChoiceClasico(List <Opcion> opciones, String texto) {
        super(opciones, texto);
        this.puntuador = new Puntuador();
    }

    @Override
    public int puntuar(Respuesta respuesta) {
        int puntos = 0;
        try {
            List<Opcion> opciones = respuesta.getOpciones();
            for (Opcion opcion : opciones) {
                puntos += opcion.puntuar();
            }
            if (puntos == this.cantidadRespuestasCorrectas() && respuesta.todasLasOpcionesMarcadasSonCorrectas()) {
                return 1;
            }
        } catch (NoMarcoOpcionExcepcion ex){
            return 0;
        }
        return 0;
    }

    @Override
    public void activarBonus(List<Integer> numeros) {
        this.puntuador.activarBonus(new Exclusividad(numeros));
    }
}
