package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KahootTest {
    @Test
    //PreCondicion_MetodoAEvaluar_PostCondicion
    public void crearCon(){
        Kahoot kahoot = new Kahoot();
        kahoot.registrarJugador("jugador1");
        kahoot.registrarJugador("jugador2");
        //kahoot.registrarPregunta(crearPregunta());

        //assertEquals(jugador.getPuntaje(), 0);
    }


    //private Pregunta crearPregunta() {
        //VerdaderoFalso verdaderoFalso = new VerdaderoFalso(new Opcion(),"una pregunta");
    //}
}
