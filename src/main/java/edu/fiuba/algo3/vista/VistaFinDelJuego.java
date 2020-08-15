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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class VistaFinDelJuego {
    private Kahoot kahoot;
    private Stage stage;

    public VistaFinDelJuego(Kahoot kahoot, Stage stage) {
        this.kahoot = kahoot;
        this.stage = stage;
    }

    public void mostrarResultado(){
        GridPane grid = new GridPane();

        grid.setId("pane");
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new Insets(20, 20, 20, 20));

        Text scenetitle = new Text("FIN DEL JUEGO!");
        Font fontTitulo = Font.loadFont("file:src/main/resources/fonts/Skranji-Bold.ttf", 38);
        scenetitle.setFont(fontTitulo);
        scenetitle.setFill(Color.WHITE);
        grid.add(scenetitle, 0, 0, 2, 1);

        Font fontGeneral = Font.loadFont("file:src/main/resources/fonts/Skranji-Regular.ttf", 20);

        List<Jugador> jugadores = kahoot.getJugadores();
        Label jugador1 = new Label("Puntaje de " + (jugadores.get(0)).getNombre()+ ":" + (jugadores.get(0)).getPuntaje());
        jugador1.setFont(fontGeneral);
        jugador1.setTextFill(Color.WHITE);

        Label jugador2 = new Label("Puntaje de " + (jugadores.get(1)).getNombre()+ ":" + (jugadores.get(1)).getPuntaje());
        jugador2.setFont(fontGeneral);
        jugador2.setTextFill(Color.WHITE);

        Label resultado = new Label("El ganador es " + kahoot.getGanador().getNombre());
        resultado.setId("ganadorDelJuego");
        resultado.setFont(fontGeneral);
        resultado.setTextFill(Color.WHITE);

        grid.add(jugador1, 0, 3);
        grid.add(jugador2, 0, 5);
        grid.add(resultado, 0, 7);

        Scene escena = new Scene(grid, 550, 450);

        File arch = new File("src/main/resources/styles/style.css");

        escena.getStylesheets().add("file:///" + arch.getAbsolutePath().replace("\\", "/")  );
        stage.setScene(escena);
    }
}
