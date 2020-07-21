package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaTest {
    @Test
    public void respuestaMarcaDosOpcionesTest(){
        Jugador jugador = new Jugador("Kevin");
        Respuesta respuesta = new Respuesta(jugador);

        respuesta.marcarOpcion(new Correcta());
        respuesta.marcarOpcion(new Incorrecta());

        assertEquals((respuesta.getOpciones()).size(), 2);
    }
}
