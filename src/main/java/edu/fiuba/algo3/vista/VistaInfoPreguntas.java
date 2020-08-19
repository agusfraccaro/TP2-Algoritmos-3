package edu.fiuba.algo3.vista;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class VistaInfoPreguntas {
    private Stage stage;

    public VistaInfoPreguntas(Stage stage) {
        this.stage = stage;
    }

    public void mostrar(){
        VBox contenedorInformacion = new VBox();
        contenedorInformacion.setId("ventanasAyuda");

        Label labelInfoVoF = new Label("Verdadero o falso: seleccione la opción que crea correcta.\n" + "Si es con penalidad, se le restará un punto si responde incorrectamente.");
        contenedorInformacion.getChildren().add(labelInfoVoF);

        Label labelInfoMC = new Label("Multiple Choice: seleccione las opciones que crea correctas.\n" + "Si es clásico se le asignará un punto si selecciona todas las opciones correctas\n" +
                "Si es parcial se le asignará un punto por opción correcta seleccionada,\n" +
                "siempre que no haya seleccionado una incorrecta.\n" +
                "Si es con penalidad se le asignará un punto por opción correcta seleccionada,\n" +
                "y se le restará un punto por opción incorrecta seleccionada.");
        contenedorInformacion.getChildren().add(labelInfoMC);

        Label labelOrdered = new Label("Ordered Choice: se le asignará un punto si ordena correctamente todas las opciones");
        contenedorInformacion.getChildren().add(labelOrdered);

        Label labelGroup = new Label("Group Choice: se le asignará un punto si asigna correctamente el grupo al que pertenece cada opción.");
        contenedorInformacion.getChildren().add(labelGroup);

        Scene escenaInfoBonus = new Scene(contenedorInformacion, 750, 400);
        stage.setScene(escenaInfoBonus);

        File archivo = new File("src/main/resources/styles/style.css");
        escenaInfoBonus.getStylesheets().add("file:///" + archivo.getAbsolutePath().replace("\\", "/")  );
    }

}
