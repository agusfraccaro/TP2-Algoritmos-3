package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorAplicarBonus;
import edu.fiuba.algo3.controlador.ControladorEnviarRespuesta;
import edu.fiuba.algo3.modelo.jugador.BONUS;
import edu.fiuba.algo3.modelo.kahoot.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.*;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class FabricaBotonBonus {
    public static VBox crearBotonBonus(Kahoot kahoot, ControladorEnviarRespuesta controladorEnviarRespuesta) {
        VBox box = new VBox();

        if (esConPenalidad(kahoot.getPreguntaActual())){
            Button btnMultiplicadorPorDos = new Button("ACTIVAR X2");
            btnMultiplicadorPorDos.setOnAction(new ControladorAplicarBonus(kahoot, btnMultiplicadorPorDos, 2, controladorEnviarRespuesta));
            btnMultiplicadorPorDos.setDisable(! kahoot.puedeAplicarMultiplicadorPor2());
            btnMultiplicadorPorDos.setUserData(BONUS.X2);

            Button btnMultiplicadorPorTres = new Button("ACTIVAR X3");
            btnMultiplicadorPorTres.setOnAction(new ControladorAplicarBonus(kahoot, btnMultiplicadorPorTres, 3, controladorEnviarRespuesta));
            btnMultiplicadorPorDos.setDisable(! kahoot.puedeAplicarMultiplicadorPor3());
            btnMultiplicadorPorTres.setUserData(BONUS.X3);
            box.getChildren().addAll(btnMultiplicadorPorDos, btnMultiplicadorPorTres);
        } else {
            Button btnExclusividad = new Button("ACTIVAR EXCLUSIVIDAD\nDE PUNTAJE");
            btnExclusividad.setOnAction(new ControladorAplicarBonus(kahoot, btnExclusividad, 2, controladorEnviarRespuesta));
            btnExclusividad.setDisable(! kahoot.puedeAplicarExclusividad());
            btnExclusividad.setUserData(BONUS.EXCLUSIVIDAD);
            box.getChildren().add(btnExclusividad);
        }
        return box;
    }

    private static Boolean esConPenalidad(Pregunta pregunta) {
        return pregunta instanceof MultipleChoiceConPenalidad || pregunta instanceof VerdaderoFalsoConPenalidad;
    }
}
