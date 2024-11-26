import MVC.Controllers.PeliculaController;
import MVC.Interfaces.IPeliculaPersistenciaDatos;
import MVC.Utilitarios.IOPelicula;
import MVC.View.PeliculaView;

public class MainPelicula {
    public static void main(String[] args) {
        PeliculaView vista = new PeliculaView();
        IPeliculaPersistenciaDatos ioPelicula = new IOPelicula();
        PeliculaController controller = new PeliculaController(vista, ioPelicula);
        controller.menuPelicula();
    }
}
