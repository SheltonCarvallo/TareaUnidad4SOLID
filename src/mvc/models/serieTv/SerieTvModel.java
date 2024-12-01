package mvc.models.serieTv;

import mvc.models.ContenidoAudiovisual;

import java.util.ArrayList;

public class SerieTvModel extends ContenidoAudiovisual {
    private final ArrayList<TemporadaModel> listaTemporadas;

    public SerieTvModel(String titulo, int duracionEnMinutos, String genero, ArrayList<TemporadaModel> listaTemporadas) {
        super(titulo, duracionEnMinutos, genero);
        this.listaTemporadas = listaTemporadas;
    }

    public ArrayList<TemporadaModel> getListaTemporadas(){
        return this.listaTemporadas;
    }
}
