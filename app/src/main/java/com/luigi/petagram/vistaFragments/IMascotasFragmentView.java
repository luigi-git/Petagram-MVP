package com.luigi.petagram.vistaFragments;

import com.luigi.petagram.adaptador.MascotaAdaptador;
import com.luigi.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface IMascotasFragmentView {

    public  void  generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorMF(MascotaAdaptador adaptador);
}
