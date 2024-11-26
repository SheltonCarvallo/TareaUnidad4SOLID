package MVC.Interfaces;

import MVC.Models.Documental.DocumentalModel;

import java.util.ArrayList;

public interface IDocumentalPersistenciaDatos {

    void guardarDatos(ArrayList<DocumentalModel> documentales);

    ArrayList<DocumentalModel> leerDatos();
}
