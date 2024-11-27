package mvc.interfaces;

import mvc.models.Documental.DocumentalModel;

import java.util.ArrayList;

public interface IDocumentalPersistenciaDatos {

    void guardarDatos(ArrayList<DocumentalModel> documentales);

    ArrayList<DocumentalModel> leerDatos();
}
