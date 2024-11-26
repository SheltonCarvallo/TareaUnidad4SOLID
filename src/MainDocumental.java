import MVC.Controllers.DocumentalController;
import MVC.Utilitarios.IODocumental;
import MVC.View.DocumentalView;


public class MainDocumental {
    public static void main(String[] args) {
        DocumentalView documentalView = new DocumentalView();
        IODocumental ioDocumental = new IODocumental();
        //CsvDocumental csvDocumental = new CsvDocumental();
        DocumentalController documentalController = new DocumentalController(documentalView, ioDocumental);
        documentalController.menuDocumental();
    }
}
