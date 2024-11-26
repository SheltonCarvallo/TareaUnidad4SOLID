package MVC.Interfaces;

import MVC.Models.Documental.DocumentalModel;
import MVC.Models.Pelicula.ActorModel;
import MVC.Models.Pelicula.PeliculaModel;

import java.util.ArrayList;

public interface IPeliculaPersistenciaDatos {
    public void guardarDatos(ArrayList<PeliculaModel> peliculas);

    public ArrayList<DocumentalModel> leerDatos();
}
