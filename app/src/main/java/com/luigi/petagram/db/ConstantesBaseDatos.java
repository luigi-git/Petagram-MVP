package com.luigi.petagram.db;

import android.renderscript.ScriptIntrinsicYuvToRGB;


public class ConstantesBaseDatos {

    public static  final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASCOTA           = "mascota";
    public static final String TABLE_MASCOTA_ID        = "id";
    public static final String TABLE_MASCOTA_NOMBRE    = "nombre";
    public static final String TABLE_MASCOTA_IMAGEN    = "imagen";

    public static final String TABLE_RATING_MASCOTA             =  "mascota_rating";
    public static final String TABLE_RATING_MASCOTA_ID          = "id";
    public static final String TABLE_RATING_MASCOTA_ID_MASCOTA  = "id_mascota";
    public static final String TABLE_RATING_MASCOTA_RATING      = "rating";

    public static final String MASCOTAS_ALL     = "registros_todos";
    public static final String MASCOTAS_TOP5    = "registros_top_cinco";
}
