package edu.fiuba.algo3.vista.fabricas;

import edu.fiuba.algo3.controlador.validacionDatos.ControladorTextoNumerico;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.preguntas.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            RadioButton botonOpcion = new RadioButton(opcion.getTexto());
            botonOpcion.setUserData(opcion);
            boxChildren.add(botonOpcion);
        }
    }

    private static void getPanelOrderedChoice(Pregunta pregunta, ObservableList<Node> boxChildren){
        ArrayList<Opcion> opcionesDesordenadas = new ArrayList<>(pregunta.getOpciones());
        Collections.shuffle(opcionesDesordenadas);

        for (Opcion opcion : opcionesDesordenadas) {
            HBox hbox = new HBox();
            hbox.setId("estiloOpcionesOrderedYGroupChoice");
            Label lblTextoOpcion = new Label(opcion.getTexto());
            TextField txtNumeroOpcion = new TextField();

            txtNumeroOpcion.textProperty().addListener(new ControladorTextoNumerico(txtNumeroOpcion, opcionesDesordenadas.size()));
            txtNumeroOpcion.setUserData(opcion);

            hbox.getChildren().addAll(lblTextoOpcion,txtNumeroOpcion);
            boxChildren.add(hbox);
        }
    }

    private static void getPanelGroupChoice(Pregunta pregunta, ObservableList<Node> boxChildren){
        List<String> grupos = new ArrayList<>();
        for (Opcion opcion : pregunta.getOpciones()){
            if (!grupos.contains(opcion.getGrupo())) grupos.add(opcion.getGrupo());
        }

        for (Opcion opcion : pregunta.getOpciones()) {
            HBox hbox = new HBox();
            hbox.setId("estiloOpcionesOrderedYGroupChoice");
            Label lblTextoOpcion = new Label(opcion.getTexto());
            ComboBox comboBox = new ComboBox(FXCollections.observableArrayList(grupos));

            hbox.getChildren().addAll(lblTextoOpcion,comboBox);
            boxChildren.add(hbox);
        }

    }

    public static Pane getPanelOpciones(Pregunta pregunta) {
        VBox layoutOpciones = new VBox();
        layoutOpciones.setId("estiloOpciones");
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