package mvc.controllers;

import mvc.interfaces.IPeliculaPersistenciaDatos;
import mvc.models.pelicula.ActorModel;
import mvc.models.pelicula.PeliculaModel;
import mvc.view.PeliculaView;


import java.util.ArrayList;

public class PeliculaController {
    public ArrayList<PeliculaModel> peliculas = new ArrayList<>();
    private final PeliculaView vista;
    private final IPeliculaPersistenciaDatos persistenciaDatos;

    public PeliculaController(PeliculaView vista, IPeliculaPersistenciaDatos persistenciaDatos) {
        this.vista = vista;
        this.persistenciaDatos = persistenciaDatos;
        uploadObjetos();
    }

    public void menuPelicula() {
        System.out.println("Bienvenido");
        boolean exit = false;
        do {
            int opcion = vista.mostrarMenuPeliculas();
            switch (opcion) {
                case 1:
                    agregarPelicula();
                    break;
                case 2:
                    actualizarVista();
                    break;
                case 3:
                    System.out.println("Bye!");
                    exit = true;
                    break;
                default:
                    vista.mostrarMenuPeliculas();
            }
        } while (!exit);
    }


    private void agregarPelicula() {
        PeliculaModel pelicula = crearPelicula();
        peliculas.add(pelicula);
        persistenciaDatos.guardarDatos(peliculas);
        actualizarVista();

    }

    private PeliculaModel crearPelicula() {
        String titulo = vista.ingresarNombrePelicula();
        int duracionMinutos = vista.ingreseDuracionMinutos();
        String genero = vista.ingresarGenero();
        int anio = vista.ingreseAnioPelicula();
        ArrayList<ActorModel> actores = vista.ingresarActores();
        return new PeliculaModel(titulo, duracionMinutos, genero, anio, actores);
    }

    private void actualizarVista() {
        vista.mostrarInformacionPelicula(peliculas);
    }

    private void uploadObjetos() {
        ArrayList<PeliculaModel> documentalesUploaded = persistenciaDatos.leerDatos();
        if (documentalesUploaded.isEmpty()) {
            return;
        }
        peliculas.addAll(documentalesUploaded); //Se cargan en memoria

    }
}
