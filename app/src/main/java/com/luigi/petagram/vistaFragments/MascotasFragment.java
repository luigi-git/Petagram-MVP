package com.luigi.petagram.vistaFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luigi.petagram.db.ConstantesBaseDatos;
import com.luigi.petagram.pojo.Mascota;
import com.luigi.petagram.R;
import com.luigi.petagram.adaptador.MascotaAdaptador;
import com.luigi.petagram.presentador.IMascotasFragmentPresenter;
import com.luigi.petagram.presentador.MascotasFragmentPresenter;

import java.util.ArrayList;

public class MascotasFragment extends Fragment implements IMascotasFragmentView {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IMascotasFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);


        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter= new MascotasFragmentPresenter(this,getContext(), ConstantesBaseDatos.MASCOTAS_ALL);
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorMF(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
