package MVC.Models.Pelicula;

public class ActorModel {
    private String nombre;
    private String apellido;

    //Asociacion
    public ActorModel(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //Getters and Setters
    public void setNombre(String nombre){

        this.nombre = nombre;
    }
    public String getNombre(){

        return nombre;
    }
    public void setApellido(String apellido){

        this.apellido = apellido;
    }
    public String getApellido(){

        return apellido;
    }
}