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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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
        VBox contenedorVertical = new VBox();
        contenedorVertical.setId("fondoInicio");
        contenedorVertical.setPadding(new Insets(30));
        contenedorVertical.setSpacing(40);
        contenedorVertical.setAlignment(Pos.CENTER);

        Text scenetitle = new Text("Bienvenidos a Kahoot!");
        Font fontTitulo = Font.loadFont("file:src/main/resources/fonts/Bangers-Regular.ttf", 60);
        scenetitle.setFont(fontTitulo);
        scenetitle.setFill(Color.rgb(0,91,153));
        contenedorVertical.getChildren().add(scenetitle);

        Font fontGeneral = Font.loadFont("file:src/main/resources/fonts/Skranji-Regular.ttf", 25);

        HBox contenedorJugador1 = new HBox();
        contenedorJugador1.setSpacing(80);
        Label lblJugador1 = new Label("Nombre jugador 1:");
        lblJugador1.setFont(fontGeneral);
        lblJugador1.setTextFill(Color.rgb(0,91,153));
        TextField txtJugador1 = new TextField();
        contenedorJugador1.setAlignment(Pos.CENTER);
        contenedorJugador1.getChildren().addAll(lblJugador1, txtJugador1);

        HBox contenedorJugador2 = new HBox();
        contenedorJugador2.setSpacing(80);
        Label lblJugador2 = new Label("Nombre jugador 2:");
        lblJugador2.setFont(fontGeneral);
        lblJugador2.setTextFill(Color.rgb(0,91,153));
        TextField txtJugador2 = new TextField();
        contenedorJugador2.setAlignment(Pos.CENTER);
        contenedorJugador2.getChildren().addAll(lblJugador2, txtJugador2);

        Button btnRegistrar = new Button("Registrar");
        btnRegistrar.setFont(fontGeneral);

        btnRegistrar.setOnAction(new ControladorRegistrarJugadores(kahoot, stage, txtJugador1, txtJugador2));

        contenedorVertical.getChildren().addAll(contenedorJugador1, contenedorJugador2);
        contenedorVertical.getChildren().add(btnRegistrar);

        Scene escena = new Scene(contenedorVertical, 550, 450);

        File arch = new File("src/main/resources/styles/style.css");
        escena.getStylesheets().add("file:///" + arch.getAbsolutePath().replace("\\", "/")  );

        stage.setScene(escena);

    }
}
