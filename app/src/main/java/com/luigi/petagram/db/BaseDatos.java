package com.luigi.petagram.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.luigi.petagram.pojo.Mascota;

import java.util.ArrayList;


public final class BaseDatos extends SQLiteOpenHelper{

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA + "("+
                                        ConstantesBaseDatos.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE + " TEXT, " +
                                        ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN + " INTEGER " +
                                        ")";
        String queryCrearTablaRatingMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_RATING_MASCOTA + "(" +
                                        ConstantesBaseDatos.TABLE_RATING_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLE_RATING_MASCOTA_ID_MASCOTA + " INTEGER, " +
                                        ConstantesBaseDatos.TABLE_RATING_MASCOTA_RATING + " INTEGER, " +
                                        "FOREIGN KEY ("+ ConstantesBaseDatos.TABLE_RATING_MASCOTA_ID_MASCOTA +") " +
                                        "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTA + "(" + ConstantesBaseDatos.TABLE_MASCOTA_ID + ")" +
                                        ")";


        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaRatingMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_RATING_MASCOTA);
        onCreate(db);
    }

    public boolean existeTablaMascotas(){
        boolean existeTabla = false;
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros =  db.rawQuery(query, null);
        if(registros.moveToNext()){
            existeTabla = true;
        }
        return existeTabla;
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros =  db.rawQuery(query, null);

        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setImagen(registros.getInt(2));

            String queryLikes = "SELECT COUNT ("+ ConstantesBaseDatos.TABLE_RATING_MASCOTA_RATING+") as rating " +
                                "FROM " + ConstantesBaseDatos.TABLE_RATING_MASCOTA +
                                " WHERE " + ConstantesBaseDatos.TABLE_RATING_MASCOTA_ID_MASCOTA + " = " + mascotaActual.getId();
            Cursor registrosRating = db.rawQuery(queryLikes, null);
            if(registrosRating.moveToNext()){
                mascotaActual.setRating(registrosRating.getInt(0));
            }
            else
            {
                mascotaActual.setRating(0);
            }

            mascotas.add(mascotaActual);
        }

        db.close();
        return mascotas;
    }

    public Mascota obtenerMascota(int idMascota){
        Mascota mascota = new Mascota();

        String query =  "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA +
                        " WHERE "+ ConstantesBaseDatos.TABLE_RATING_MASCOTA_ID + "=" + idMascota;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros =  db.rawQuery(query, null);
        if(registros.moveToNext()){
            mascota.setId(registros.getInt(0));
            mascota.setNombre(registros.getString(1));
            mascota.setImagen(registros.getInt(2));
        }
        db.close();
        return mascota;
    }

    public ArrayList<Mascota> obtenerTop5Mascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT " + ConstantesBaseDatos.TABLE_RATING_MASCOTA_ID_MASCOTA +", count("+ ConstantesBaseDatos.TABLE_RATING_MASCOTA_ID_MASCOTA +") as rating "+
                        "FROM " + ConstantesBaseDatos.TABLE_RATING_MASCOTA + " GROUP BY " + ConstantesBaseDatos.TABLE_RATING_MASCOTA_ID_MASCOTA +
                        " HAVING (COUNT(" + ConstantesBaseDatos.TABLE_RATING_MASCOTA_ID_MASCOTA + ")>=1) ORDER BY rating DESC LIMIT 0, 5";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros =  db.rawQuery(query, null);

        while(registros.moveToNext()){

            Mascota mascotaTop = obtenerMascota(registros.getInt(0));
            mascotaTop.setRating(registros.getInt(1));
            mascotas.add(mascotaTop);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarRatingMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_RATING_MASCOTA, null, contentValues);
        db.close();
    }

    public int obtenerRatingMascota(Mascota mascota){
        int rating = 0;

        String query =  "SELECT COUNT("+ ConstantesBaseDatos.TABLE_RATING_MASCOTA_RATING +") " +
                        "FROM " +ConstantesBaseDatos.TABLE_RATING_MASCOTA +
                        " WHERE " + ConstantesBaseDatos.TABLE_RATING_MASCOTA_ID_MASCOTA + " = " +
                        mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if(registros.moveToNext()){
            rating = registros.getInt(0);
        }
        db.close();
        return rating;
    }

}
