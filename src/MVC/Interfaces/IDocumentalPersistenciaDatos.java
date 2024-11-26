package MVC.Interfaces;

import MVC.Models.Documental.DocumentalModel;

import java.util.ArrayList;

public interface IDocumentalPersistenciaDatos {

    public void guardarDatos(ArrayList<DocumentalModel> documentales);

    public ArrayList<DocumentalModel> leerDatos();
}
