package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.opcion.ConPenalidad;
import edu.fiuba.algo3.modelo.opcion.Correcta;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.SinPenalidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OpcionTest {

    @Test
    public void opcionSeAsignaElTextoCorrectamenteTest(){
        Opcion opcion = new Opcion("texto opcion", new Correcta());

        assertEquals("texto opcion", opcion.getTexto());
    }

    @Test
    public void opcionConEstadoCorrectaSePuntuaCorrectamenteTest(){
        Opcion opcion = new Opcion("texto", new Correcta());

        assertEquals(1, opcion.puntuar());
    }

    @Test
    public void opcionConEstadoCorrectaEsCorrectaTest(){
        Opcion opcion = new Opcion("texto", new Correcta());

        assertTrue(opcion.esCorrecta());
    }

    @Test
    public void opcionConEstadoSinPenalidadSePuntuaCorrectamenteTest(){
        Opcion opcion = new Opcion("texto", new SinPenalidad());

        assertEquals(0, opcion.puntuar());
    }

    @Test
    public void opcionConEstadoSinPenalidadNoEsCorrectaTest(){
        Opcion opcion = new Opcion("texto", new SinPenalidad());

        assertFalse(opcion.esCorrecta());
    }

    @Test
    public void opcionConEstadoConPenalidadSePuntuaCorrectamenteTest(){
        Opcion opcion = new Opcion("texto", new ConPenalidad());

        assertEquals(-1, opcion.puntuar());
    }

    @Test
    public void opcionConEstadoConPenalidadNoEsCorrectaTest(){
        Opcion opcion = new Opcion("texto", new ConPenalidad());

        assertFalse(opcion.esCorrecta());
    }

    @Test
    public void opcionConEstadoNoNuloNoTieneGrupoTest(){
        Opcion opcion1 = new Opcion("texto", new Correcta());
        Opcion opcion2 = new Opcion("texto", new SinPenalidad());

        assertEquals(null, opcion1.getGrupo());
        assertEquals(null, opcion2.getGrupo());
    }

    @Test
    public void opcionSeAsignaGrupoCorrectamenteTest(){
        Opcion opcion = new Opcion("texto", "grupo 1");

        assertEquals("grupo 1", opcion.getGrupo());
    }

    @Test
    public void opcionConEstadoNuloPuntuaCeroPuntosTest(){
        Opcion opcion = new Opcion("texto");

        assertEquals(0, opcion.puntuar());
    }

    @Test
    public void metodoEqualsDevuelveTrueSiElObjetoRecibidoEsIgualALaOpcionTest(){
        Opcion opcion = new Opcion("opcion");

        assertEquals(true, opcion.equals(opcion));
    }

    @Test
    public void metodoEqualsDevuelveFalseSiElObjetoRecibidoEsNullTest(){
        Opcion opcion = new Opcion("opcion");
        Opcion opcion1 = null;

        assertEquals(false, opcion.equals(opcion1));
    }
}
