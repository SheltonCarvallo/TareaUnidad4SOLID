import mvc.controllers.SerieTvController;
import mvc.interfaces.ISerieTvPesistenciaDatos;
import mvc.utilitarios.IOSerieTv;
import mvc.view.SerieTvView;

public class MainSerieTv {
    public static void main(String[] args) {
        SerieTvView vista = new SerieTvView();
        ISerieTvPesistenciaDatos serieTvPesistenciaDatos = new IOSerieTv();
        SerieTvController controller = new SerieTvController(vista, serieTvPesistenciaDatos);
        controller.menuSerieTv();
    }
}
