package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorIniciarJuego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class VistaInicioJuego {

    private Stage stage;
    private Kahoot kahoot;

    public VistaInicioJuego(Kahoot kahoot, Stage stage){
        this.kahoot = kahoot;
        this.stage = stage;
    }

    public void mostrarInicio(){
        VBox contenedorVertical = new VBox();
        contenedorVertical.setId("inicio");

        Text scenetitle = new Text("INFO JUGADORES");
        scenetitle.setId("titulo");
        contenedorVertical.getChildren().add(scenetitle);

        List<Jugador> jugadores = kahoot.getJugadores();
        Label jugador1 = new Label("Nombre jugador 1: " + (jugadores.get(0)).getNombre());
        jugador1.setId("info");

        Label jugador2 = new Label("Nombre jugador 2: " + (jugadores.get(1)).getNombre());
        jugador2.setId("info");

        contenedorVertical.getChildren().addAll(jugador1, jugador2);

        Button btnInicio = new Button("Iniciar juego!");
        btnInicio.setOnAction(new ControladorIniciarJuego(kahoot, stage));
        contenedorVertical.getChildren().add(btnInicio);

        Scene escena = new Scene(contenedorVertical, 700, 550);

        File arch = new File("src/main/resources/styles/style.css");

        escena.getStylesheets().add("file:///" + arch.getAbsolutePath().replace("\\", "/")  );
        stage.setScene(escena);
    }
}
