package edu.fiuba.algo3.vista;

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

public class App extends Application {

    private Scene getGame(Stage stage,String nombreJugador1, String nombreJugador2) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(30, 30, 30, 30));

        Text scenetitle = new Text("Bienvenido al juego");

        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label lblJugador1 = new Label("Nombre jugador 1: " + nombreJugador1);
        grid.add(lblJugador1, 0, 2);

        Label lblJugador2 = new Label("Nombre jugador 2: " + nombreJugador2);
        grid.add(lblJugador2, 0, 3);

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

    private EventHandler<ActionEvent> eventoRegistrarJugador(Stage stage, TextField jugador1, TextField jugador2) {
        return new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                if (jugador1.getText().length() > 0 && jugador2.getText().length() > 0)
                    stage.setScene(getGame(stage,jugador1.getText(),jugador2.getText()));
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