package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorIniciarJuego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
        GridPane grid = new GridPane();

        grid.setId("pane");
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new Insets(20, 20, 20, 20));

        Text scenetitle = new Text("INFO JUGADORES");
        Font fontTitulo = Font.loadFont("file:src/main/resources/fonts/Skranji-Bold.ttf", 38);
        scenetitle.setFont(fontTitulo);
        scenetitle.setFill(Color.WHITE);
        grid.add(scenetitle, 0, 0, 2, 1);

        Font fontGeneral = Font.loadFont("file:src/main/resources/fonts/Skranji-Regular.ttf", 20);

        List<Jugador> jugadores = kahoot.getJugadores();
        Label jugador1 = new Label("Nombre jugador 1: " + (jugadores.get(0)).getNombre());
        jugador1.setFont(fontGeneral);
        jugador1.setTextFill(Color.WHITE);

        Label jugador2 = new Label("Nombre jugador 2: " + (jugadores.get(1)).getNombre());
        jugador2.setFont(fontGeneral);
        jugador2.setTextFill(Color.WHITE);

        grid.add(jugador1, 0, 3);
        grid.add(jugador2, 0, 5);

        Button btnInicio = new Button("Iniciar juego!");
        btnInicio.setFont(fontGeneral);
        btnInicio.setOnAction(new ControladorIniciarJuego(kahoot, stage));
        grid.add(btnInicio, 1, 7);

        Scene escena = new Scene(grid, 550, 450);

        File arch = new File("src/main/resources/styles/style.css");

        escena.getStylesheets().add("file:///" + arch.getAbsolutePath().replace("\\", "/")  );
        stage.setScene(escena);
    }
}
