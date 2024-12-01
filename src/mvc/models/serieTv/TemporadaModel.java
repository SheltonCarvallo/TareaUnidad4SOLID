package mvc.models.serieTv;

import java.io.Serializable;

public class TemporadaModel implements Serializable {
    private String nombre;
    private int numeroTemporada;
    private int capitulos;


    public TemporadaModel(String nombre, int numeroTemporada, int capitulos) {
        this.nombre = nombre;
        this.numeroTemporada = numeroTemporada;
        this.capitulos = capitulos;
    }

    //Getters and Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNumeroTemporada(int numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    public int getNumeroTemporada() {
        return numeroTemporada;
    }

    public void setCapitulos(int capitulos) {
        this.capitulos = capitulos;
    }

    public int getCapitulos() {
        return capitulos;
    }
}
