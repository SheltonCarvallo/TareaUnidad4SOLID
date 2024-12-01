package mvc.models.pelicula;

import mvc.models.ContenidoAudiovisual;
import java.util.ArrayList;

public class PeliculaModel extends ContenidoAudiovisual {
    private int anio;
    private final ArrayList<ActorModel> actores;

    public PeliculaModel(String titulo, int duracionEnMinutos, String genero, int anio, ArrayList<ActorModel> actores) {
        super(titulo, duracionEnMinutos, genero);
        this.anio = anio;
        this.actores = actores;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public ArrayList<ActorModel> getActores() {
        return actores;
    }


}