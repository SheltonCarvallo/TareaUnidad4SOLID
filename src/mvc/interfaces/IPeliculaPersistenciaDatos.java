package mvc.interfaces;

import mvc.models.pelicula.PeliculaModel;

import java.util.ArrayList;

public interface IPeliculaPersistenciaDatos {

    void guardarDatos(ArrayList<PeliculaModel> peliculas);

    ArrayList<PeliculaModel> leerDatos();
}
