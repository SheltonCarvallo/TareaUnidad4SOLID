package MVC.Interfaces;

import MVC.Models.Pelicula.PeliculaModel;

import java.util.ArrayList;

public interface IPeliculaPersistenciaDatos {

    void guardarDatos(ArrayList<PeliculaModel> peliculas);

    ArrayList<PeliculaModel> leerDatos();
}
