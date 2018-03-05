package com.luigi.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import com.luigi.petagram.R;
import com.luigi.petagram.pojo.Mascota;

import java.util.ArrayList;


public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerMascotas(String filtro){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        switch (filtro)
        {
            case ConstantesBaseDatos.MASCOTAS_TOP5: mascotas = db.obtenerTop5Mascotas();
                break;
            case ConstantesBaseDatos.MASCOTAS_ALL: mascotas = db.obtenerTodasLasMascotas();
                break;
        }
        return mascotas;
    }

    public void insertarMascotas(BaseDatos db){

        if(!(db.existeTablaMascotas())){
            ContentValues contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Micky");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,  R.drawable.raton);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Patas");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,  R.drawable.conejo);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Manchas");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,  R.drawable.gato);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Bigotes");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,  R.drawable.hamster);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Franky");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,  R.drawable.perico);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Thor");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,  R.drawable.perro);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Lazaro");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,  R.drawable.pez);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Crispin");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,  R.drawable.raton_1);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Octavio");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,  R.drawable.tarantula);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Timoty");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,  R.drawable.pez_2);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Doroteo");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,  R.drawable.perico_2);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Miguelito");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,  R.drawable.raton_2);
            db.insertarMascota(contentValues);
        }
    }

    public void darRaiting(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_RATING_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_RATING_MASCOTA_RATING, LIKE);
        db.insertarRatingMascota(contentValues);
    }

    public int obtenerRatingMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerRatingMascota(mascota);
    }
}
