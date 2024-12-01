package mvc.interfaces;


import mvc.models.serieTv.SerieTvModel;

import java.util.ArrayList;

public interface ISerieTvPesistenciaDatos {

    void guardarDatos(ArrayList<SerieTvModel> seriesTv);

    ArrayList<SerieTvModel> leerDatos();
}
