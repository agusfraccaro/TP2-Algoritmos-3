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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(30, 30, 30, 30));

        Text scenetitle = new Text("Bienvenido al juego");

        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        List<Jugador> jugadores = kahoot.getJugadores();
        Label jugador1 = new Label("Nombre jugador 1: " + (jugadores.get(0)).getNombre());
        Label jugador2 = new Label("Nombre jugador 2: " + (jugadores.get(1)).getNombre());

        grid.add(jugador1, 0, 2);
        grid.add(jugador2, 0, 4);

        Button btnInicio = new Button("Iniciar juego");
        btnInicio.setOnAction(new ControladorIniciarJuego(kahoot, stage));
        grid.add(btnInicio, 0, 6);

        stage.setScene(new Scene(grid, 550, 450));
    }
}
