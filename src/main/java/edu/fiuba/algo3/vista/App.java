package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class App extends Application {

    Kahoot kahoot = new Kahoot();

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

        return new VerdaderoFalso(opciones,"Texto de la segunda pregunta y esta es con penalidad");
    }

    private Scene getGame(Stage stage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(30, 30, 30, 30));

        Text scenetitle = new Text("Bienvenido al juego");

        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label lblJugador1 = new Label("Nombre jugador 1: " + kahoot.getJugadores().get(0).getNombre());
        grid.add(lblJugador1, 0, 2);

        Label lblJugador2 = new Label("Nombre jugador 2: " + kahoot.getJugadores().get(1).getNombre());
        grid.add(lblJugador2, 0, 3);

        Label lblPregunta = new Label( kahoot.getSiguientePregunta().getTexto());
        grid.add(lblPregunta, 0, 4);

        //Aca se puede hacer con un for que itere sobre las opciones de la pregunta y se cree dinamicamente segun eso
        RadioButton rbOpcion1 = new RadioButton("opcion 1");
        RadioButton rbOpcion2 = new RadioButton("opcion 2");

        ToggleGroup group = new ToggleGroup();
        rbOpcion1.setToggleGroup(group);
        rbOpcion2.setToggleGroup(group);

        grid.add(rbOpcion1, 0, 5);
        grid.add(rbOpcion2, 1, 5);

        Button btnEvaluar = new Button("Evaluar respuestas");
        btnEvaluar.setOnAction(eventoEvaluarRespuesta(stage));
        grid.add(btnEvaluar, 1, 6);

        return new Scene(grid, 350, 250);
    }

    private Scene getLogin(Stage stage) {
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(30, 30, 30, 30));

        Text scenetitle = new Text("Bienvenido a Kahoot");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label lblJugador1 = new Label("Nombre jugador 1:");
        grid.add(lblJugador1, 0, 2);

        TextField txtJugador1 = new TextField();
        grid.add(txtJugador1, 1, 2);

        Label lblJugador2 = new Label("Nombre jugador 2:");
        grid.add(lblJugador2, 0, 3);

        TextField txtJugador2 = new TextField();
        grid.add(txtJugador2, 1, 3);

        Button btnRegistrar = new Button("Registrar");

        btnRegistrar.setOnAction(eventoRegistrarJugador(stage,txtJugador1,txtJugador2));

        grid.add(btnRegistrar, 1, 4);

        return new Scene(grid, 350, 250);
    }

    private EventHandler<ActionEvent>  eventoEvaluarRespuesta(Stage stage) {
        return e -> {
            //Aca se evalua la respuesta del jugador
            //Suponiendo que fue bien paso a la nueva pregunta
            stage.setScene(getGame(stage));
        };
    }
    private void registrarJugadores(TextField jugador1,TextField jugador2) {
        kahoot.registrarJugador(jugador1.getText());
        kahoot.registrarJugador(jugador2.getText());
    }

    private void registrarPreguntas() {
        kahoot.registrarPregunta(getPreguntaVerdaderoFalso());
        kahoot.registrarPregunta(getPreguntaVerdaderoFalsoConPenalidad());
        //Se pueden agregar mas preguntas
        kahoot.cargarPreguntas();
    }

    private EventHandler<ActionEvent> eventoRegistrarJugador(Stage stage, TextField jugador1, TextField jugador2) {
        return e -> {
            if (jugador1.getText().length() > 0 && jugador2.getText().length() > 0){
                registrarJugadores(jugador1,jugador2);
                registrarPreguntas();
                stage.setScene(getGame(stage));
            }
            else {
                Alert alert = new Alert(Alert.AlertType.NONE,
                        "Debe ingresar los nombres de ambos jugadores",ButtonType.OK);
                alert.show();
            }
        };
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Kahoot");

        Scene login = getLogin(stage);

        stage.setScene(login);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}