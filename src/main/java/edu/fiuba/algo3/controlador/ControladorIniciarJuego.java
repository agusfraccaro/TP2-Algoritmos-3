package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import edu.fiuba.algo3.modelo.opcion.ConPenalidad;
import edu.fiuba.algo3.modelo.opcion.Correcta;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.SinPenalidad;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import edu.fiuba.algo3.vista.VistaPreguntas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorIniciarJuego implements EventHandler<ActionEvent> {

    private Kahoot kahoot;
    private Stage stage;

    public  ControladorIniciarJuego(Kahoot kahoot, Stage stage){
        this.kahoot = kahoot;
        this.stage = stage;
    }

    private void registrarPreguntas() {
        //Mover a JSON/XML
        kahoot.registrarPregunta(getPreguntaVerdaderoFalso());
        kahoot.registrarPregunta(getPreguntaVerdaderoFalsoConPenalidad());

        kahoot.cargarPreguntas();
    }

    private VerdaderoFalso getPreguntaVerdaderoFalso() {
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion correcta", new Correcta()));
        opciones.add(new Opcion("Opcion Incorrecta", new SinPenalidad()));

        return new VerdaderoFalso(opciones,"Texto de la primer pregunta");
    }

    private VerdaderoFalso getPreguntaVerdaderoFalsoConPenalidad() {
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion correcta", new Correcta()));
        opciones.add(new Opcion("Opcion Incorrecta", new ConPenalidad()));

        return new VerdaderoFalso(opciones, "Texto de la segunda pregunta y esta es con penalidad");
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        registrarPreguntas();
        kahoot.iniciarRonda();
        (new VistaPreguntas(kahoot, stage)).mostrarPregunta();
    }
}
