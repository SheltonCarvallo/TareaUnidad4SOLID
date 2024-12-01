package mvc.utilitarios;

import mvc.interfaces.IPeliculaPersistenciaDatos;
import mvc.models.pelicula.PeliculaModel;

import java.io.*;
import java.util.ArrayList;

public class IOPelicula implements IPeliculaPersistenciaDatos {
    private static final String File_Name = "pelicula.csv";



    @Override
    public void guardarDatos(ArrayList<PeliculaModel> peliculas) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(File_Name)){
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(peliculas);
            System.out.println("Lista de objetos serializada en el archivo " + File_Name);
        } catch (IOException ex){
            System.out.println("Problema: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<PeliculaModel> leerDatos() {
        if(existeArchivo()){
            try (FileInputStream fileInputStream = new FileInputStream(File_Name)) {
                ObjectInputStream ois = new ObjectInputStream(fileInputStream);
                Object objetos = ois.readObject();
                return (ArrayList<PeliculaModel>) objetos; // casting
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("Problema: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    private boolean existeArchivo() {
        File f1 = new File(File_Name);
        return f1.exists();
    }
}
