package mvc.controllers;

import mvc.interfaces.IDocumentalPersistenciaDatos;
import mvc.models.Documental.DocumentalModel;
import mvc.models.Documental.InvestigadorModel;
import mvc.view.DocumentalView;

import java.util.ArrayList;


public class DocumentalController {
    public ArrayList<DocumentalModel> documentales = new ArrayList<>();
    private final DocumentalView vista;
    private final IDocumentalPersistenciaDatos documentalPersistenciaDatos;

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

    private void agregarDocumental() {

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

    private void actualizarVista() {
        vista.mostrarInformacionDocumental(documentales);
    }

    private void uploadObjetos() {
        ArrayList<DocumentalModel> documentalesUploaded = documentalPersistenciaDatos.leerDatos();
        if (documentalesUploaded.isEmpty()) {
            return;
        }
        documentales.addAll(documentalesUploaded); //Se cargan en memoria

    }
}
