package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;

public class VistaInfoBonus {
    private Stage stage;

    public VistaInfoBonus(Stage infoBonus) {
        this.stage = infoBonus;
    }

    public void mostrar(){
        VBox contenedorInformacion = new VBox();
        contenedorInformacion.setId("ventanasAyuda");

        Label labelInfo = new Label("EXCLUSIVIDAD: Duplica puntaje en caso de que un solo jugador responda correctamente.\n"
                + "X2: Duplica puntaje para el jugador que seleccione el Bonus.\n"
                + "X2: Duplica puntaje para el jugador que seleccione el Bonus.\n");
        contenedorInformacion.getChildren().add(labelInfo);

        Scene escenaInfoBonus = new Scene(contenedorInformacion, 650, 190);
        stage.setScene(escenaInfoBonus);

        File archivo = new File("src/main/resources/styles/style.css");
        escenaInfoBonus.getStylesheets().add("file:///" + archivo.getAbsolutePath().replace("\\", "/")  );
    }
}
