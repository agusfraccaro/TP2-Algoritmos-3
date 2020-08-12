package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.excepciones.EstadoNuloNoEsIncorrectoNiCorrectoExcepcion;
import edu.fiuba.algo3.modelo.excepciones.EstadoNuloNoPuntuaExcepcion;

public class EstadoNulo implements EstadoOpcion {
    @Override
    public int puntuar() throws EstadoNuloNoPuntuaExcepcion {
        throw new EstadoNuloNoPuntuaExcepcion();
    }

    @Override
    public boolean esCorrecta() throws EstadoNuloNoEsIncorrectoNiCorrectoExcepcion {
        throw new EstadoNuloNoEsIncorrectoNiCorrectoExcepcion();
    }
}
