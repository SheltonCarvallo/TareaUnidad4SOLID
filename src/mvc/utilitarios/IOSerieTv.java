package mvc.utilitarios;

import mvc.interfaces.ISerieTvPesistenciaDatos;
import mvc.models.pelicula.PeliculaModel;
import mvc.models.serieTv.SerieTvModel;

import java.io.*;
import java.util.ArrayList;

public class IOSerieTv implements ISerieTvPesistenciaDatos {
    private static final String File_Name = "seriesTv.csv";

    @Override
    public void guardarDatos(ArrayList<SerieTvModel> seriesTv) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(File_Name)){
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(seriesTv);
            System.out.println("Lista de objetos serializada en el archivo " + File_Name);
        } catch (IOException ex){
            System.out.println("Problema: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<SerieTvModel> leerDatos() {
        if(existeArchivo()){
            try (FileInputStream fileInputStream = new FileInputStream(File_Name)) {
                ObjectInputStream ois = new ObjectInputStream(fileInputStream);
                Object objetos = ois.readObject();
                return (ArrayList<SerieTvModel>) objetos; // casting
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
