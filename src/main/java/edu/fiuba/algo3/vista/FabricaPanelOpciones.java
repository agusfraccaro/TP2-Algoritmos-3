package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.preguntas.*;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.List;

public class FabricaPanelOpciones {
    public static Pane getOptionsPane(Pregunta pregunta) {
        VBox optionsLayout = new VBox();
        optionsLayout.setSpacing(16);
        optionsLayout.setAlignment(Pos.CENTER);
        ObservableList<Node> boxChildren = optionsLayout.getChildren();

        if (esVerdaderoFalso(pregunta)) {
            ToggleGroup toggleGroup = new ToggleGroup();
            for (Opcion opcion : pregunta.getOpciones()) {
                RadioButton optionButton = new RadioButton(opcion.getTexto());
                optionButton.setUserData(opcion);
                optionButton.setToggleGroup(toggleGroup);
                boxChildren.add(optionButton);
            }
        } else if (esMultipleChoice(pregunta)) {
            for (Opcion opcion : pregunta.getOpciones()) {
                RadioButton optionButton = new RadioButton(opcion.getTexto());
                optionButton.setUserData(opcion);
                boxChildren.add(optionButton);
            }
        } else if (pregunta instanceof OrderedChoice) {

        } else if (pregunta instanceof GroupChoice) {

        }
        return optionsLayout;

    }

    private static Boolean esVerdaderoFalso(Pregunta pregunta) {
        return pregunta instanceof VerdaderoFalso || pregunta instanceof VerdaderoFalsoConPenalidad;
    }

    private static Boolean esMultipleChoice(Pregunta pregunta) {
        return pregunta instanceof MultipleChoiceClasico ||
                pregunta instanceof MultipleChoiceConPenalidad ||
                pregunta instanceof MultipleChoiceParcial;
    }
}