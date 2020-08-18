package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.kahoot.Kahoot;

import javafx.application.Application;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    Kahoot kahoot = new Kahoot();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Kahoot");

        //Media media = new Media((App.class.getResource("/music/musica_kahoot.mp3")).toExternalForm());
        //AudioClip reproductor = new AudioClip(media.getSource());
        //reproductor.setCycleCount(AudioClip.INDEFINITE);
        //reproductor.play(0.2);

        stage.getIcons().add(new Image((App.class.getResource("/images/icono.png")).toExternalForm()));

        (new VistaRegistroJugadores(kahoot, stage)).mostrarRegistro();

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}