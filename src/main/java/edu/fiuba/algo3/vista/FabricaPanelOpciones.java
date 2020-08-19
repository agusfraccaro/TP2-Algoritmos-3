package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorTextoNumerico;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.preguntas.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.converter.IntegerStringConverter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.UnaryOperator;

public class FabricaPanelOpciones {

    private static void getPanelVerdaderoFalso(Pregunta pregunta, ObservableList<Node> boxChildren){
        ToggleGroup toggleGroup = new ToggleGroup();
        for (Opcion opcion : pregunta.getOpciones()) {
            RadioButton botonOpcion = new RadioButton(opcion.getTexto());
            botonOpcion.setUserData(opcion);
            botonOpcion.setToggleGroup(toggleGroup);
            boxChildren.add(botonOpcion);
        }
    }

    private static void getPanelMultipleChoice(Pregunta pregunta, ObservableList<Node> boxChildren){
        for (Opcion opcion : pregunta.getOpciones()) {
            RadioButton optionButton = new RadioButton(opcion.getTexto());
            optionButton.setUserData(opcion);
            boxChildren.add(optionButton);
        }
    }

    private static void getPanelOrderedChoice(Pregunta pregunta, ObservableList<Node> boxChildren){
        ArrayList<Opcion> opcionesDesordenadas =  new ArrayList<Opcion>(pregunta.getOpciones());
        Collections.shuffle(opcionesDesordenadas);

        for (Opcion opcion : opcionesDesordenadas) {
            HBox hbox = new HBox();
            Label lblTextoOpcion = new Label(opcion.getTexto());
            TextField txtNumeroOpcion = new TextField();
            txtNumeroOpcion.setMaxWidth(40);
            txtNumeroOpcion.textProperty().addListener(new ControladorTextoNumerico(txtNumeroOpcion, opcionesDesordenadas.size()));
            txtNumeroOpcion.setUserData(opcion);
            hbox.getChildren().addAll(lblTextoOpcion,txtNumeroOpcion);
            hbox.setSpacing(5);
            hbox.setAlignment(Pos.CENTER);
            boxChildren.add(hbox);
        }
    }

    private static boolean validate(String text) {
        return text.matches("[0-9]*");
    }


    private static void getPanelGroupChoice(Pregunta pregunta, ObservableList<Node> boxChildren){
        List<String> grupos = new ArrayList<>();
        for (Opcion opcion : pregunta.getOpciones()){
            if (!grupos.contains(opcion.getGrupo())) grupos.add(opcion.getGrupo());
        }

        for (Opcion opcion : pregunta.getOpciones()) {
            HBox hbox = new HBox();
            Label lblTextoOpcion = new Label(opcion.getTexto());
            ComboBox comboBox = new ComboBox(FXCollections.observableArrayList(grupos));

            hbox.getChildren().addAll(lblTextoOpcion,comboBox);
            hbox.setSpacing(8);
            hbox.setAlignment(Pos.CENTER);
            boxChildren.add(hbox);
        }

    }

    public static Pane getPanelOpciones(Pregunta pregunta) {
        VBox layoutOpciones = new VBox();
        layoutOpciones.setSpacing(16);
        layoutOpciones.setAlignment(Pos.CENTER);
        ObservableList<Node> boxChildren = layoutOpciones.getChildren();

        if (esVerdaderoFalso(pregunta)) {
            getPanelVerdaderoFalso(pregunta, boxChildren);
        } else if (esMultipleChoice(pregunta)) {
            getPanelMultipleChoice(pregunta, boxChildren);
        } else if (pregunta instanceof OrderedChoice) {
            getPanelOrderedChoice(pregunta, boxChildren);
        } else if (pregunta instanceof GroupChoice) {
            getPanelGroupChoice(pregunta, boxChildren);
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