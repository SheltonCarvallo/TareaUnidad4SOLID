package mvc.controllers;

import mvc.interfaces.ISerieTvPesistenciaDatos;
import mvc.models.serieTv.SerieTvModel;
import mvc.models.serieTv.TemporadaModel;
import mvc.view.SerieTvView;

import java.util.ArrayList;

public class SerieTvController {
    public ArrayList<SerieTvModel> seriesTv = new ArrayList<>();
    private final SerieTvView vista;
    private final ISerieTvPesistenciaDatos serieTvPersistenciaDatos;

    public SerieTvController(SerieTvView vista, ISerieTvPesistenciaDatos serieTvPersistenciaDatos) {
        this.vista = vista;
        this.serieTvPersistenciaDatos = serieTvPersistenciaDatos;
        uploadObjetos(); //si existen datos previamente guardados serán cargados
    }

    public void menuSerieTv() {
        System.out.println("Bienvenido");
        boolean exit = false;
        do {

            int opcion = vista.mostrarSerieTvMenu();
            switch (opcion) {
                case 1:
                    agregarSerieTv();
                    break;
                case 2:
                    actualizarVista();
                    break;
                case 3:
                    System.out.println("Bye!");
                    exit = true;
                    break;
                default:
                    vista.mostrarSerieTvMenu();
            }

        } while (!exit);

    }

    private void agregarSerieTv() {

        SerieTvModel documental = crearSerieTv();
        seriesTv.add(documental);
        serieTvPersistenciaDatos.guardarDatos(seriesTv);
        actualizarVista();

    }

    private SerieTvModel crearSerieTv() {
        String tituloSerie = vista.ingresarTituloSerieTv();
        int duracionMinutos = vista.ingresarDuracionMinutos();
        String genero = vista.ingresarGeneroSerieTv();
        //int numeroTemporada = vista.ingresarTemporadas();
        ArrayList<TemporadaModel> temporadas = vista.ingresarTemporadas();
        return new SerieTvModel(tituloSerie, duracionMinutos, genero, temporadas);
    }

    private void actualizarVista() {
        vista.mostrarInformacionSerieTv(seriesTv);
    }

    protected void uploadObjetos() {
        ArrayList<SerieTvModel> documentalesUploaded = serieTvPersistenciaDatos.leerDatos();
        if (documentalesUploaded.isEmpty()) {
            return;
        }
        seriesTv.addAll(documentalesUploaded); //Se cargan en memoria

    }
}
