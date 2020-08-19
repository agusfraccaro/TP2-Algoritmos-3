package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorRegistrarJugadores;
import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

public class VistaRegistroJugadores {
    private final Kahoot kahoot;
    private final Stage stage;

    public VistaRegistroJugadores(Kahoot kahoot, Stage stage){
        this.kahoot= kahoot;
        this.stage = stage;
    }

    public void mostrarRegistro(){
        VBox contenedorVertical = new VBox();
        contenedorVertical.setId("inicio");

        Text scenetitle = new Text("Bienvenidos a Kahoot!");

        scenetitle.setId("titulo");
        contenedorVertical.getChildren().add(scenetitle);

        HBox contenedorJugador1 = new HBox();
        contenedorJugador1.setId("contenedorJugadores");

        Label lblJugador1 = new Label("Nombre jugador 1:");
        lblJugador1.setId("info");

        TextField txtJugador1 = new TextField();
        contenedorJugador1.getChildren().addAll(lblJugador1, txtJugador1);

        HBox contenedorJugador2 = new HBox();
        contenedorJugador2.setId("contenedorJugadores");
        Label lblJugador2 = new Label("Nombre jugador 2:");
        lblJugador2.setId("info");

        TextField txtJugador2 = new TextField();
        contenedorJugador2.getChildren().addAll(lblJugador2, txtJugador2);

        Button btnRegistrar = new Button("Registrar");

        btnRegistrar.setOnAction(new ControladorRegistrarJugadores(kahoot, stage, txtJugador1, txtJugador2));

        contenedorVertical.getChildren().addAll(contenedorJugador1, contenedorJugador2);
        contenedorVertical.getChildren().add(btnRegistrar);

        Scene escena = new Scene(contenedorVertical, 700, 550);

        File arch = new File("src/main/resources/styles/style.css");
        escena.getStylesheets().add("file:///" + arch.getAbsolutePath().replace("\\", "/")  );

        stage.setScene(escena);

    }
}
