package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.excepciones.EstadoNuloNoEsIncorrectoNiCorrectoExcepcion;
import edu.fiuba.algo3.modelo.excepciones.EstadoNuloNoPuntuaExcepcion;

public interface EstadoOpcion {

    public abstract int puntuar() throws EstadoNuloNoPuntuaExcepcion;
    public abstract boolean esCorrecta() throws EstadoNuloNoEsIncorrectoNiCorrectoExcepcion;
}
