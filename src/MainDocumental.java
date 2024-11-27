import mvc.controllers.DocumentalController;
import mvc.utilitarios.IODocumental;
import mvc.view.DocumentalView;


public class MainDocumental {
    public static void main(String[] args) {
        DocumentalView documentalView = new DocumentalView();
        IODocumental ioDocumental = new IODocumental();
        DocumentalController documentalController = new DocumentalController(documentalView, ioDocumental);
        documentalController.menuDocumental();
    }
}
