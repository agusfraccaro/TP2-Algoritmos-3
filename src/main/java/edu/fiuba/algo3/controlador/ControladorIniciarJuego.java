package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.excepciones.NoHaySiguientePreguntaExcepcion;
import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import edu.fiuba.algo3.modelo.opcion.ConPenalidad;
import edu.fiuba.algo3.modelo.opcion.Correcta;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.SinPenalidad;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoiceParcial;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalsoConPenalidad;
import edu.fiuba.algo3.vista.VistaPreguntas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControladorIniciarJuego implements EventHandler<ActionEvent> {

    private Kahoot kahoot;
    private Stage stage;

    public  ControladorIniciarJuego(Kahoot kahoot, Stage stage){
        this.kahoot = kahoot;
        this.stage = stage;
    }

    private VerdaderoFalso getPreguntaVerdaderoFalso() {
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion correcta", new Correcta()));
        opciones.add(new Opcion("Opcion Incorrecta", new SinPenalidad()));

        return new VerdaderoFalso(opciones,"Texto de la primer pregunta");
    }

    private MultipleChoiceParcial getPreguntaMultipleChoiceParcial() {
        Opcion correcta1 = new Opcion("opcion1", new Correcta());
        Opcion correcta2 = new Opcion("opcion2", new Correcta());
        Opcion correcta3 = new Opcion("opcion3", new Correcta());
        List<Opcion> opciones = new ArrayList<Opcion>(){
            {add(correcta1); add(correcta2); add(correcta3); add(new Opcion("opcion4", new SinPenalidad()));};
        };

        return new MultipleChoiceParcial(opciones, "una pregunta");
    }

    private VerdaderoFalsoConPenalidad getPreguntaVerdaderoFalsoConPenalidad() {
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion correcta", new Correcta()));
        opciones.add(new Opcion("Opcion Incorrecta", new ConPenalidad()));

        return new VerdaderoFalsoConPenalidad(opciones, "Texto de la segunda pregunta y esta es con penalidad");
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            kahoot.cargarPreguntas();
            kahoot.iniciarRonda();
        } catch (NoHaySiguientePreguntaExcepcion | IOException noHaySiguientePreguntaExcepcion) {
        }
        (new VistaPreguntas(kahoot, stage)).mostrarPregunta();
    }
}
