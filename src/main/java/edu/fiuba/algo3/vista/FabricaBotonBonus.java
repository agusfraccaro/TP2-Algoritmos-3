package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorAplicarBonus;
import edu.fiuba.algo3.controlador.ControladorEnviarRespuesta;
import edu.fiuba.algo3.modelo.preguntas.*;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class FabricaBotonBonus {
    public static VBox crearBotonBonus(Pregunta pregunta, ControladorEnviarRespuesta controladorEnviarRespuesta) {
        VBox box = new VBox();

        if (esConPenalidad(pregunta)){
            Button btnMultiplicadorPorDos = new Button("ACTIVAR X2");
            btnMultiplicadorPorDos.setOnAction(new ControladorAplicarBonus(2,controladorEnviarRespuesta));
            Button btnMultiplicadorPorTres = new Button("ACTIVAR X3");
            btnMultiplicadorPorTres.setOnAction(new ControladorAplicarBonus(3,controladorEnviarRespuesta));
            box.getChildren().addAll(btnMultiplicadorPorDos, btnMultiplicadorPorTres);
        } else {
            Button btnExclusividad = new Button("ACTIVAR EXCLUSIVIDAD\nDE PUNTAJE");
            btnExclusividad.setOnAction(new ControladorAplicarBonus(2,controladorEnviarRespuesta));
            box.getChildren().add(btnExclusividad);
        }
        return box;
    }

    private static Boolean esConPenalidad(Pregunta pregunta) {
        return pregunta instanceof MultipleChoiceConPenalidad || pregunta instanceof VerdaderoFalsoConPenalidad;
    }
}
