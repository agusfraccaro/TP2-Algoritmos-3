package edu.fiuba.algo3.vista;

import javafx.application.Application;
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

    private Scene getGame(Stage stage) {
        GridPane grid = new GridPane();
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

        btnRegistrar.setOnAction(e -> stage.setScene(getGame(stage)));

        grid.add(btnRegistrar, 1, 4);

        return new Scene(grid, 350, 250);
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