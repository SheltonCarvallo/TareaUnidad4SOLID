package MVC.Models.Documental;

import MVC.Models.ContenidoAudiovisual;

import java.util.ArrayList;

public class DocumentalModel extends ContenidoAudiovisual {

    //version de serialización
    private static final long serialVersionUID = 1L;

    private final ArrayList<InvestigadorModel> investigadores;

    public DocumentalModel(String titulo, int duracionEnMinutos, String genero, ArrayList<InvestigadorModel> investigadores) {
        super(titulo, duracionEnMinutos, genero);
        this.investigadores = investigadores;
    }

    public ArrayList<InvestigadorModel> getInvestigadores() {
        return investigadores;
    }

}
