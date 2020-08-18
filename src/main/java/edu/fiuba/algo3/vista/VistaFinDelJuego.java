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
import javafx.scene.layout.VBox;
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
        VBox contenedorVertical = new VBox();
        contenedorVertical.setId("fondoResultados");
        contenedorVertical.setSpacing(40);
        contenedorVertical.setAlignment(Pos.CENTER);
        contenedorVertical.setPadding(new Insets(30));

        Text tituloFinal = new Text("FIN DEL JUEGO!");
        Font fontTitulo = Font.loadFont("file:src/main/resources/fonts/Bangers-Regular.ttf", 60);
        tituloFinal.setFont(fontTitulo);
        tituloFinal.setFill(Color.rgb(0,91,153));
        contenedorVertical.getChildren().add(tituloFinal);

        Font fontGeneral = Font.loadFont("file:src/main/resources/fonts/Skranji-Regular.ttf", 25);

        List<Jugador> jugadores = kahoot.getJugadores();
        Label jugador1 = new Label("Puntaje de " + (jugadores.get(0)).getNombre()+ ": " + (jugadores.get(0)).getPuntaje());
        jugador1.setFont(fontGeneral);
        jugador1.setTextFill(Color.rgb(0,91,153));

        Label jugador2 = new Label("Puntaje de " + (jugadores.get(1)).getNombre()+ ": " + (jugadores.get(1)).getPuntaje());
        jugador2.setFont(fontGeneral);
        jugador2.setTextFill(Color.rgb(0,91,153));

        Label resultado = new Label();
        if(kahoot.getGanador() != null) {
            resultado.setText("El ganador es " + kahoot.getGanador().getNombre());
        }else{
            resultado.setText("Empate!");
        }
        resultado.setFont(fontTitulo);
        resultado.setTextFill(Color.rgb(0,91,153));

        contenedorVertical.getChildren().addAll(jugador1, jugador2, resultado);

        Scene escena = new Scene(contenedorVertical, 550, 450);

        File arch = new File("src/main/resources/styles/style.css");

        escena.getStylesheets().add("file:///" + arch.getAbsolutePath().replace("\\", "/")  );
        stage.setScene(escena);
    }
}
