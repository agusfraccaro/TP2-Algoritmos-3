package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.puntuador.Exclusividad;
import edu.fiuba.algo3.modelo.preguntas.puntuador.Multiplicador;
import edu.fiuba.algo3.modelo.preguntas.puntuador.Puntuador;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntuadorTest {

    @Test
    public void PuntuadorActivaBonusExclusividadCorrectamente(){
        Puntuador puntuador = new Puntuador();
        Exclusividad exclusividad = new Exclusividad(new ArrayList<>() {{
            add(1);
            add(1);
        }});

        puntuador.activarBonus(exclusividad);

        assertEquals(puntuador.getBonus(), exclusividad);
    }

    @Test
    public void PuntuadorActivaBonusMultiplicadorCorrectamente(){
        Puntuador puntuador = new Puntuador();
        Multiplicador multiplicador= new Multiplicador((new ArrayList<>() {{
            add(1);
            add(1);
        }}));

        puntuador.activarBonus(multiplicador);

        assertEquals(puntuador.getBonus(), multiplicador);
    }
}
