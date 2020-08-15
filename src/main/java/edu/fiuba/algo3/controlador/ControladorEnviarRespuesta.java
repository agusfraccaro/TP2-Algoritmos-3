package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.excepciones.NoHaySiguientePreguntaExcepcion;
import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.vista.ContenedorOpcion;
import edu.fiuba.algo3.vista.Temporizador;
import edu.fiuba.algo3.vista.VistaFinDelJuego;
import edu.fiuba.algo3.vista.VistaPreguntas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ControladorEnviarRespuesta implements EventHandler<ActionEvent> {
    private final Kahoot kahoot;
    private final VistaPreguntas vista;
    private final int cantidadRespuestas;
    private final Stage stage;
    private final List<ContenedorOpcion> botones;
    private int extra;

    public ControladorEnviarRespuesta(Kahoot kahoot, VistaPreguntas vista, Stage stage, int cantidadRespuestas, List<ContenedorOpcion> botones){
        this.kahoot = kahoot;
        this.cantidadRespuestas = cantidadRespuestas;
        this.vista = vista;
        this.stage = stage;
        this.botones = botones;
    }

    public void setExtraPorBonus(int extra) {
        this.extra = extra;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        List<Opcion> respuesta = new ArrayList<>();
        Opcion opcionSeleccionada;
        for(ContenedorOpcion boton : botones) {
            opcionSeleccionada = boton.getOpcionSeleccionada(); //devuelve la Opcion si esta fue seleccionada; sino, null
            if(opcionSeleccionada != null){
                respuesta.add(opcionSeleccionada);
            }
        }
        kahoot.enviarRespuesta(respuesta,1);

        try {
            if (cantidadRespuestas == 2) {
                kahoot.iniciarRonda();
            }
            //vista.mostrarPregunta();
            new VistaPreguntas(kahoot, stage).mostrarPregunta();
        }catch (NoHaySiguientePreguntaExcepcion noHaySiguientePreguntaExcepcion) {
                new VistaFinDelJuego(kahoot, stage).mostrarResultado();
        }
    }
}
