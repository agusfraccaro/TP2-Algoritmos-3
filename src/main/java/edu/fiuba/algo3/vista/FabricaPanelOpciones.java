package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.preguntas.*;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

import java.util.List;

public class FabricaPanelOpciones {
    public void crearPanelParaOpciones(Pregunta pregunta, GridPane grid, List<ContenedorOpcion> botones)
    {
        botones.clear();

        if (pregunta instanceof VerdaderoFalso || pregunta instanceof VerdaderoFalsoConPenalidad){
            int i = 0;
            ToggleGroup group = new ToggleGroup();
            for (Opcion opcion : pregunta.getOpciones()) {
                botones.add(new ContenedorOpcion(opcion));
                botones.get(i).getBoton().setToggleGroup(group);

                grid.add((botones.get(i)).getBoton(), 0, 5+i);
                i++;
            }
        }

        else if (pregunta instanceof OrderedChoice) {

        }

        else if (esMultipleChoice(pregunta)) {
            int i = 0;
            for (Opcion opcion : pregunta.getOpciones()) {
                botones.add(new ContenedorOpcion(opcion));
                grid.add((botones.get(i)).getBoton(), 0, 5+i);
                i++;
            }
        }

        else if (pregunta instanceof GroupChoice) {

        }

    }


    private Boolean esMultipleChoice(Pregunta pregunta) {
        return pregunta instanceof MultipleChoiceClasico ||
                pregunta instanceof MultipleChoiceConPenalidad ||
                pregunta instanceof MultipleChoiceParcial;
    }
}