import mvc.controllers.PeliculaController;
import mvc.interfaces.IPeliculaPersistenciaDatos;
import mvc.utilitarios.IOPelicula;
import mvc.view.PeliculaView;

public class MainPelicula {
    public static void main(String[] args) {
        PeliculaView vista = new PeliculaView();
        IPeliculaPersistenciaDatos ioPelicula = new IOPelicula();
        PeliculaController controller = new PeliculaController(vista, ioPelicula);
        controller.menuPelicula();
    }
}
