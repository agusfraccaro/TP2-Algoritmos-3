package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.preguntas.*;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FabricaPanelOpciones {
    public static Pane getPanelOpciones(Pregunta pregunta) {
        VBox layoutOpciones = new VBox();
        layoutOpciones.setSpacing(16);
        layoutOpciones.setAlignment(Pos.CENTER);
        ObservableList<Node> boxChildren = layoutOpciones.getChildren();

        if (esVerdaderoFalso(pregunta)) {
            ToggleGroup toggleGroup = new ToggleGroup();
            for (Opcion opcion : pregunta.getOpciones()) {
                RadioButton botonOpcion = new RadioButton(opcion.getTexto());
                botonOpcion.setUserData(opcion);
                botonOpcion.setToggleGroup(toggleGroup);
                boxChildren.add(botonOpcion);
            }
        } else if (esMultipleChoice(pregunta)) {
            for (Opcion opcion : pregunta.getOpciones()) {
                RadioButton optionButton = new RadioButton(opcion.getTexto());
                optionButton.setUserData(opcion);
                boxChildren.add(optionButton);
            }
        } else if (pregunta instanceof OrderedChoice) {
            ArrayList<Opcion> opcionesDesordenadas =  new ArrayList<Opcion>(pregunta.getOpciones());
            Collections.shuffle(opcionesDesordenadas);

            for (Opcion opcion : opcionesDesordenadas) {
                HBox hbox = new HBox();
                Label lblTextoOpcion = new Label(opcion.getTexto());
                TextField txtNumeroOpcion = new TextField();
                txtNumeroOpcion.setMaxWidth(25);
                txtNumeroOpcion.setUserData(opcion);
                hbox.getChildren().addAll(lblTextoOpcion,txtNumeroOpcion);
                hbox.setSpacing(5);
                hbox.setAlignment(Pos.CENTER);
                boxChildren.add(hbox);
            }

        } else if (pregunta instanceof GroupChoice) {

        }
        return layoutOpciones;

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