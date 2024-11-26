package MVC.Utilitarios;

import MVC.Interfaces.IDocumentalPersistenciaDatos;
import MVC.Models.Documental.DocumentalModel;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class CsvDocumental implements IDocumentalPersistenciaDatos {
    private static final String File_Name = "DocumentalesCSVPrueba.csv";


    @Override
    public void guardarDatos(ArrayList<DocumentalModel> documentales) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(File_Name))) {
            for (DocumentalModel doc : documentales) {
                writer.write(doc.getTitulo() + "," + doc.getDuracionEnMinutos() + "," + doc.getGenero() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<DocumentalModel> leerDatos() {
        if(existeArchivo())
        {
            ArrayList<DocumentalModel> listaDocumentales = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(File_Name))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    String titulo = data[0];
                    int duracion = Integer.parseInt(data[1]);
                    String genero = data[2];
                    listaDocumentales.add(new DocumentalModel(titulo, duracion, genero, new ArrayList<>())); // Replace empty list with actual Investigadores
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return listaDocumentales;
        }
        return null;

    }

    private boolean existeArchivo(){
        File f1 = new File(File_Name);
        return f1.exists();
    }

}
