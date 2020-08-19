package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
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

    public void mostrarResultado() {
        VBox contenedorVertical = new VBox();
        contenedorVertical.setId("fondoResultados");

        Text tituloFinal = new Text("FIN DEL JUEGO!");
        tituloFinal.setId("titulo");
        contenedorVertical.getChildren().add(tituloFinal);

        List<Jugador> jugadores = kahoot.getJugadores();
        Label jugador1 = new Label("Puntaje de " + (jugadores.get(0)).getNombre()+ ": " + (jugadores.get(0)).getPuntaje());
        jugador1.setId("info");

        Label jugador2 = new Label("Puntaje de " + (jugadores.get(1)).getNombre()+ ": " + (jugadores.get(1)).getPuntaje());
        jugador2.setId("info");

        Label resultado = new Label();
        if(kahoot.getGanador() != null) {
            resultado.setText("El ganador es " + kahoot.getGanador().getNombre());
        }else{
            resultado.setText("Empate!");
        }
        resultado.setId("titulo");

        contenedorVertical.getChildren().addAll(jugador1, jugador2, resultado);

        Scene escena = new Scene(contenedorVertical, 700, 550);

        File arch = new File("src/main/resources/styles/style.css");

        escena.getStylesheets().add("file:///" + arch.getAbsolutePath().replace("\\", "/")  );
        stage.setScene(escena);
    }
}
