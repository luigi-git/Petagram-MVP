package com.luigi.petagram.presentador;

import android.content.Context;

import com.luigi.petagram.db.ConstructorMascotas;
import com.luigi.petagram.pojo.Mascota;
import com.luigi.petagram.vistaFragments.IMascotasFragmentView;

import java.util.ArrayList;

public class MascotasFragmentPresenter implements IMascotasFragmentPresenter {

    private IMascotasFragmentView iMascotasFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;
    private String filtro;

    public MascotasFragmentPresenter(IMascotasFragmentView iMascotasFragmentView, Context context, String filtro){
        this.iMascotasFragmentView = iMascotasFragmentView;
        this.context = context;
        this.filtro = filtro;
        obtenerMascotasBaseDatos(filtro);
    }

    @Override
    public void obtenerMascotasBaseDatos(String filtro) {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerMascotas(filtro);
        mostrarMascotasMF();
    }

    @Override
    public void mostrarMascotasMF() {
        iMascotasFragmentView.inicializarAdaptadorMF(iMascotasFragmentView.crearAdaptador(mascotas));
        iMascotasFragmentView.generarLinearLayoutVertical();
    }
}
