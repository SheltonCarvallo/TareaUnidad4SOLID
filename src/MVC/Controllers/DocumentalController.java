package MVC.Controllers;

import MVC.Interfaces.IDocumentalPersistenciaDatos;
import MVC.Models.Documental.DocumentalModel;
import MVC.Models.Documental.InvestigadorModel;
import MVC.View.DocumentalView;

import java.util.ArrayList;
import java.util.Scanner;

public class DocumentalController {
    public ArrayList<DocumentalModel> documentales = new ArrayList<>();
    private final DocumentalView vista;
    private final IDocumentalPersistenciaDatos documentalPersistenciaDatos;
    public Scanner scanner = new Scanner(System.in);

    public DocumentalController(DocumentalView vista, IDocumentalPersistenciaDatos documentalPersistenciaDatos) {
        this.vista = vista;
        this.documentalPersistenciaDatos = documentalPersistenciaDatos;
        uploadObjetos(); //si existen datos previamente guardados serán cargados
    }

    public void menuDocumental() {
        System.out.println("Bienvenido");
        boolean exit = false;
        do {

            int opcion = vista.mostrarDocumentalMenu();
            switch (opcion) {
                case 1:
                    agregarDocumental();
                    break;
                case 2:
                    actualizarVista();
                    break;
                case 3:
                    System.out.println("Bye!");
                    exit = true;
                    break;
                default:
                    vista.mostrarDocumentalMenu();
            }

        } while (!exit);

    }

    public void agregarDocumental() {

        DocumentalModel documental = crearDocumental();
        documentales.add(documental);
        documentalPersistenciaDatos.guardarDatos(documentales);
        actualizarVista();

    }

    private DocumentalModel crearDocumental() {
        String tituloDocumental = vista.ingresarTituloDocumental();
        int duracionMinutos = vista.ingresarDuracionMinutos();
        String genero = vista.ingresarGeneroDocumental();
        ArrayList<InvestigadorModel> investigadores = vista.ingresarInvestigadoresDocumental();
        return new DocumentalModel(tituloDocumental, duracionMinutos, genero, investigadores);
    }

    public void actualizarVista() {
        vista.mostrarInformacionDocumental(documentales);
    }

    public void uploadObjetos() {
        ArrayList<DocumentalModel> documentalesUploaded = documentalPersistenciaDatos.leerDatos();
        if (documentalesUploaded.isEmpty()) {
            return;
        }
        documentales.addAll(documentalesUploaded); //Se cargan en memoria

    }
}
