package mvc.utilitarios;

import java.io.*;
import java.util.ArrayList;


import mvc.interfaces.IDocumentalPersistenciaDatos;
import mvc.models.documental.DocumentalModel;

public class IODocumental implements IDocumentalPersistenciaDatos {

    private static final String File_Name = "Documentales.csv";

    @Override
    public void guardarDatos(ArrayList<DocumentalModel> listaDocumentales) {
        try (FileOutputStream fileOutStream = new FileOutputStream(File_Name)) {
            ObjectOutputStream oos = new ObjectOutputStream(fileOutStream);
            oos.writeObject(listaDocumentales);
            System.out.println("Lista de objetos serializada en el archivo " + File_Name);
        } catch (IOException ex) {
            System.out.println("Problema: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<DocumentalModel> leerDatos() {
        if (existeArchivo()) {
            try (FileInputStream fileInputStream = new FileInputStream(File_Name)) {
                ObjectInputStream ois = new ObjectInputStream(fileInputStream);
                Object objetos = ois.readObject();
                return (ArrayList<DocumentalModel>) objetos; //casting
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
