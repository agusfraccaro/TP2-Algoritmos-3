package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.excepciones.EstadoNuloNoEsIncorrectoNiCorrectoExcepcion;
import edu.fiuba.algo3.modelo.excepciones.EstadoNuloNoPuntuaExcepcion;

public interface EstadoOpcion {

    int puntuar() throws EstadoNuloNoPuntuaExcepcion;
    boolean esCorrecta() throws EstadoNuloNoEsIncorrectoNiCorrectoExcepcion;
}
