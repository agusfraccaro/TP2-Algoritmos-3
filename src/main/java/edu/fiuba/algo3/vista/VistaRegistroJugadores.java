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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

public class VistaRegistroJugadores {
    private Kahoot kahoot;
    private Stage stage;

    public VistaRegistroJugadores(Kahoot kahoot, Stage stage){
        this.kahoot= kahoot;
        this.stage = stage;
    }

    public void mostrarRegistro(){
        GridPane grid = new GridPane();

        grid.setId("pane");
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new Insets(20, 20, 20, 20));

        Text scenetitle = new Text("Bienvenidos a Kahoot!");
        Font fontTitulo = Font.loadFont("file:src/main/resources/fonts/Skranji-Bold.ttf", 45);
        scenetitle.setFont(fontTitulo);
        scenetitle.setFill(Color.WHITE);
        grid.add(scenetitle, 0, 0, 2, 1);

        Font fontGeneral = Font.loadFont("file:src/main/resources/fonts/Skranji-Regular.ttf", 20);

        Label lblJugador1 = new Label("Nombre jugador 1:");
        lblJugador1.setFont(fontGeneral);
        lblJugador1.setTextFill(Color.WHITE);
        grid.add(lblJugador1, 0, 2);

        TextField txtJugador1 = new TextField();
        grid.add(txtJugador1, 1, 2);

        Label lblJugador2 = new Label("Nombre jugador 2:");
        lblJugador2.setFont(fontGeneral);
        lblJugador2.setTextFill(Color.WHITE);
        grid.add(lblJugador2, 0, 3);

        TextField txtJugador2 = new TextField();
        grid.add(txtJugador2, 1, 3);

        Button btnRegistrar = new Button("Registrar");
        btnRegistrar.setFont(fontGeneral);

        btnRegistrar.setOnAction(new ControladorRegistrarJugadores(kahoot, stage, txtJugador1, txtJugador2));

        grid.add(btnRegistrar, 2, 5);

        Scene escena = new Scene(grid, 550, 450);

        File arch = new File("src/main/resources/styles/style.css");
        escena.getStylesheets().add("file:///" + arch.getAbsolutePath().replace("\\", "/")  );

        stage.setScene(escena);

    }
}
