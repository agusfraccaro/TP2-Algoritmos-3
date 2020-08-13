package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import edu.fiuba.algo3.modelo.opcion.ConPenalidad;
import edu.fiuba.algo3.modelo.opcion.Correcta;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.SinPenalidad;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import javafx.application.Application;
import javafx.application.Platform;
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
import javafx.scene.control.CheckBox;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App extends Application {

    Kahoot kahoot = new Kahoot();
    List<CheckBox> radioButtons = new ArrayList<CheckBox>();
    int cantidadRespuestas = 0;

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

    private Scene getGame(Stage stage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(30, 30, 30, 30));

        Text scenetitle = new Text("Bienvenido al juego");

        /*Label main_clock_lb = new Label();

        Thread timerThread = new Thread(() -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            while (true) {
                try {
                    Thread.sleep(1000); //1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final String time = simpleDateFormat.format(new Date());
                Platform.runLater(() -> {
                    main_clock_lb.setText(time);
                });
            }
        });   timerThread.start();//start the thread and its ok*/

        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        //grid.add(main_clock_lb,0,0,3,2);

        Label lblJugadorActual = new Label("Turno de: " + kahoot.getJugadorActual());
        //arreglar, solo se ve el puntaje del 1er jugador
        List jugadores = kahoot.getJugadores();
        Jugador jug = (Jugador) jugadores.get(0);
        Label puntaje = new Label("Puntos: " + jug.getPuntaje());
        grid.add(puntaje, 0, 3);
        grid.add(lblJugadorActual, 0, 2);

        Label lblPregunta = new Label( kahoot.getPreguntaActual().getTexto());
        grid.add(lblPregunta, 0, 4);

        int i = 0;
        for (Opcion opcion : kahoot.getPreguntaActual().getOpciones()) {
            CheckBox rbOpcion = new CheckBox(opcion.getTexto());

            radioButtons.add(rbOpcion);
            grid.add(rbOpcion, 0, 5+i);
            i++;
        }

        Button btnResponder = new Button("Responder");
        btnResponder.setOnAction(eventoEnviarRespuesta(stage));
        grid.add(btnResponder,1,6+i);


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

    private EventHandler<ActionEvent> eventoEnviarRespuesta(Stage stage) {
        return e -> {
            List<Opcion> respuesta = new ArrayList<Opcion>();
            respuesta.add(kahoot.getPreguntaActual().getOpciones().get(0));
            for(CheckBox radioButton : radioButtons) {
                //if (radioButton.isSelected())
                    //respuesta.add();
            }
            kahoot.enviarRespuesta(respuesta,1);
            cantidadRespuestas++;

            if (cantidadRespuestas == 2){
                kahoot.iniciarRonda();
                cantidadRespuestas = 0;
            }
            stage.setScene(getGame(stage));
        };
    }

    private void registrarJugadores(TextField jugador1,TextField jugador2) {
        kahoot.registrarJugador(jugador1.getText());
        kahoot.registrarJugador(jugador2.getText());
    }

    private void registrarPreguntas() {
        //Mover a JSON/XML
        kahoot.registrarPregunta(getPreguntaVerdaderoFalso());
        kahoot.registrarPregunta(getPreguntaVerdaderoFalsoConPenalidad());

        kahoot.cargarPreguntas();
    }

    private EventHandler<ActionEvent> eventoRegistrarJugador(Stage stage, TextField jugador1, TextField jugador2) {
        return e -> {
            if (jugador1.getText().length() > 0 && jugador2.getText().length() > 0){
                registrarJugadores(jugador1,jugador2);
                registrarPreguntas();
                kahoot.iniciarRonda();
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