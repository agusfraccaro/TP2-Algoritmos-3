package edu.fiuba.algo3.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.modelo.opcion.*;
import edu.fiuba.algo3.modelo.preguntas.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;

public class JsonSerializer {
    public List<Pregunta> leerPreguntasDesdeJSON(String archivo) {
        try{
            String texto = Files.readString(Path.of(archivo));

            JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

            return recuperarPreguntas(jsonObject);
        }
        catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.NONE,
                    "No se pudo leer el archivo", ButtonType.OK);
            alert.show();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.NONE,
                    "Hubo problemas al leer el archivo", ButtonType.OK);
            alert.show();
        }

        return new ArrayList<Pregunta>();
    }

    private List<Pregunta> recuperarPreguntas(JsonObject jsonObject) throws Exception {
        JsonArray arrayJsonPreguntas = (JsonArray) jsonObject.get("preguntas");
        ArrayList<Pregunta> arrayPreguntas = new ArrayList<Pregunta>();
        for (JsonElement jsonObjectPregunta : arrayJsonPreguntas) {
            arrayPreguntas.add(crearPregunta(jsonObjectPregunta.getAsJsonObject()));
        }
        return arrayPreguntas;
    }


    /*
    private void prueba(JsonObject jsonObject,  IntConsumer function) {
        function.();
    }*/


    private List<Opcion> getOpcionesGroupChoice(JsonObject jsonObject) {
        JsonArray arrayOpciones = (JsonArray)jsonObject.get("opciones");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        for (JsonElement jsonObjectOpcion : arrayOpciones) {
            opciones.add(crearOpcionGroupChoice(jsonObjectOpcion.getAsJsonObject()));
        }
        return opciones;
    }

    private List<Opcion> getOpcionesOrderedChoice(JsonObject jsonObject) {
        JsonArray arrayOpciones = (JsonArray)jsonObject.get("opciones");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        for (JsonElement jsonObjectOpcion : arrayOpciones) {
            opciones.add(crearOpcionOrderedChoice(jsonObjectOpcion.getAsJsonObject()));
        }
        return opciones;
    }

    private List<Opcion> getOpciones(JsonObject jsonObject) {
        JsonArray arrayOpciones = (JsonArray)jsonObject.get("opciones");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        for (JsonElement jsonObjectOpcion : arrayOpciones) {
            opciones.add(crearOpcion(jsonObjectOpcion.getAsJsonObject()));
        }
        return opciones;
    }

    private String getTextoOpcion(JsonObject jsonObject) {
        return jsonObject.get("textoOpcion").getAsString();
    }

    private EstadoOpcion getEstadoOpcion(JsonObject jsonObject) {
        if (jsonObject.get("estadoOpcion").getAsString().equals("Correcta"))
            return new Correcta();
        else if (jsonObject.get("estadoOpcion").getAsString().equals("SinPenalidad"))
            return new SinPenalidad();
        else
            return new ConPenalidad();
    }

    private String getGrupoOpcion(JsonObject jsonObject) {
        return jsonObject.get("grupoOpcion").getAsString();
    }

    private Opcion crearOpcionGroupChoice(JsonObject jsonObject) {
        // Opcion(String texto, String grupo)
        return new Opcion(getTextoOpcion(jsonObject),getGrupoOpcion(jsonObject));
    }

    private Opcion crearOpcionOrderedChoice(JsonObject jsonObject) {
        //Opcion(String texto)
        return new Opcion(getTextoOpcion(jsonObject));
    }

    private Opcion crearOpcion(JsonObject jsonObject) {
        //Opcion(String texto, EstadoOpcion estado)
        return new Opcion(getTextoOpcion(jsonObject),getEstadoOpcion(jsonObject));
    }

    private String getTextoPregunta(JsonObject jsonObject) {
        return jsonObject.get("textoPregunta").getAsString();
    }

    private Pregunta crearPregunta(JsonObject jsonObject) throws Exception {
        String tipoPregunta = jsonObject.get("tipoPregunta").getAsString();

        switch(tipoPregunta) {
            case "VerdaderoFalso":
                VerdaderoFalso verdaderoFalso = new VerdaderoFalso(getOpciones(jsonObject),getTextoPregunta(jsonObject));
                return verdaderoFalso;
            case "VerdaderoFalsoConPenalidad":
                VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidad(getOpciones(jsonObject),getTextoPregunta(jsonObject));
                return verdaderoFalsoConPenalidad;
            case "MultipleChoiceClasico":
                MultipleChoiceClasico multipleChoiceClasico = new MultipleChoiceClasico(getOpciones(jsonObject),getTextoPregunta(jsonObject));
                return multipleChoiceClasico;
            case "GroupChoice":
                GroupChoice groupChoice = new GroupChoice(getOpcionesGroupChoice(jsonObject),getTextoPregunta(jsonObject));
                return groupChoice;
            case "MultipleChoiceConPenalidad":
                MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(getOpciones(jsonObject),getTextoPregunta(jsonObject));
                return multipleChoiceConPenalidad;
            case "MultipleChoiceParcial":
                MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(getOpciones(jsonObject),getTextoPregunta(jsonObject));
                return multipleChoiceParcial;
            case "OrderedChoice":
                OrderedChoice orderedChoice = new OrderedChoice(getOpcionesOrderedChoice(jsonObject),getTextoPregunta(jsonObject));
                return orderedChoice;
            default:
                throw new Exception("Pregunta invalida");
        }
    }
}
