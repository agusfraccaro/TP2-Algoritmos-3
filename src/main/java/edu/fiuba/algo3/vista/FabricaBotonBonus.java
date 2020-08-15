package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorAplicarBonus;
import edu.fiuba.algo3.controlador.ControladorEnviarRespuesta;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.preguntas.*;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

import java.util.List;

public class FabricaBotonBonus {
    public void crearBotonBonus(Pregunta pregunta, GridPane grid, ControladorEnviarRespuesta controladorEnviarRespuesta)
    {
        if (esConPenalidad(pregunta)){ //Multiplicador
            Button btnMultiplicadorPorDos = new Button("Multiplicador x2");
            btnMultiplicadorPorDos.setOnAction(new ControladorAplicarBonus(2,controladorEnviarRespuesta));
            Button btnMultiplicadorPorTres = new Button("Multiplicador x3");
            btnMultiplicadorPorTres.setOnAction(new ControladorAplicarBonus(3,controladorEnviarRespuesta));
            grid.add(btnMultiplicadorPorDos, 0, 18);
            grid.add(btnMultiplicadorPorTres, 0, 19);
        }

        else { //Exclusividad
            Button btnExclusividad = new Button("Exclusividad de Puntaje");
            btnExclusividad.setOnAction(new ControladorAplicarBonus(2,controladorEnviarRespuesta));
            grid.add(btnExclusividad, 0, 18);
        }

    }

    private Boolean esConPenalidad(Pregunta pregunta) {
        return pregunta instanceof MultipleChoiceConPenalidad ||
                pregunta instanceof VerdaderoFalsoConPenalidad;
    }
}
