package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorRegistrarJugadores;
import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VistaRegistroJugadores {
    private Kahoot kahoot;
    private Stage stage;

    public VistaRegistroJugadores(Kahoot kahoot, Stage stage){
        this.kahoot= kahoot;
        this.stage = stage;
    }

    public void mostrarRegistro(){
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

        btnRegistrar.setOnAction(new ControladorRegistrarJugadores(kahoot, stage, txtJugador1, txtJugador2));

        grid.add(btnRegistrar, 1, 4);
        grid.setId("pane");
        Scene escena = new Scene(grid, 550, 450);
        escena.getStylesheets().addAll(this.getClass().getResource("/styles/style.css").toExternalForm());

        stage.setScene(escena);

    }
}
