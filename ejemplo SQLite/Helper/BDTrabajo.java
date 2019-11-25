package com.efebyte.sqlitetrabajo.Helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class BDTrabajo extends SQLiteOpenHelper {


    /* Clase interna que define el contenido de la tabla */
    public static class DatosTabla implements BaseColumns {

        public static final String NOMBRE_TABLA = "Datos";
        public static final String COLUMNA_ID = "id";
        public static final String COLUMNA_UBICACION = "ubicacion";
        public static final String COLUMNA_CALLE = "calle";
        public static final String COLUMNA_LOTE= "lote";
        public static final String COLUMNA_USUARIO = "usuario";
        public static final String COLUMNA_FECHA = "fecha";

        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";
        private static final String SQL_CREAR_TABLA =
                "CREATE TABLE " + DatosTabla.NOMBRE_TABLA + " (" +
                        DatosTabla.COLUMNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        DatosTabla.COLUMNA_UBICACION + TEXT_TYPE + COMMA_SEP +
                        DatosTabla.COLUMNA_CALLE + TEXT_TYPE + COMMA_SEP +
                        DatosTabla.COLUMNA_LOTE + TEXT_TYPE + COMMA_SEP +
                        DatosTabla.COLUMNA_USUARIO + TEXT_TYPE + COMMA_SEP +
                        DatosTabla.COLUMNA_FECHA + TEXT_TYPE + " )";

        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + DatosTabla.NOMBRE_TABLA;
    }

    // Si se cambia el Chema de la Base de datos, hay que incrementar el numero de la Version
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "miBD.db";

    public BDTrabajo(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //se ejecuta por primera vez cuando no esta la Base de Datos
        db.execSQL(DatosTabla.SQL_CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //se ejecuta cuando hay una nueva version de la BD
        // dropDatabase();
        //  createDatabase();
    }

    public void DeleteDatos(SQLiteDatabase db){
        //db.delete(DatosTabla.SQL_DELETE_ENTRIES,null,null);
        db.execSQL(DatosTabla.SQL_DELETE_ENTRIES);
        db.execSQL(DatosTabla.SQL_CREAR_TABLA);
        db.close();
    }

    public Cursor getAll(SQLiteDatabase db, String Tabla){

        String[] columnas = {
                DatosTabla.COLUMNA_ID,
                DatosTabla.COLUMNA_UBICACION,
                DatosTabla.COLUMNA_CALLE,
                DatosTabla.COLUMNA_LOTE,
                DatosTabla.COLUMNA_USUARIO,
                DatosTabla.COLUMNA_FECHA,
        };

        Cursor c = db.query(
                DatosTabla.NOMBRE_TABLA,                     // La tabla de la Consulta
                columnas,                               // Las columnas que se retornan
                null,                                // Las columnas que se usaran en el WHERE
                null,                            // Los Valores que pasaras el WHERE
                null,                                     // no agrupar las columnas
                null,                                     // no filtrarr por grupo de columna
                null                                 // El Orden ASC o DESC
        );

        return c;
    }


    public Cursor getPorCalle(SQLiteDatabase db, String where){

        String[] columnas = {
                DatosTabla.COLUMNA_ID,
                DatosTabla.COLUMNA_UBICACION,
                DatosTabla.COLUMNA_CALLE,
                DatosTabla.COLUMNA_LOTE,
                DatosTabla.COLUMNA_USUARIO,
                DatosTabla.COLUMNA_FECHA,
        };

        Cursor c = db.query(
                DatosTabla.NOMBRE_TABLA,
                columnas,
                where,
                null,
                null,
                null,
                null
        );

        return c;
    }


    // Metodo para obtener un registro
    // var db = base de datos
    // var dato = criterio por el cual se filtra
    // var valor = el valor que se busca
    public Cursor getOne(SQLiteDatabase db, String dato, String valor){
        String[] args = new String[] {valor};
        String sql = "Select "+ DatosTabla.COLUMNA_ID+","+DatosTabla.COLUMNA_USUARIO  +","+DatosTabla.COLUMNA_UBICACION +","+DatosTabla.COLUMNA_CALLE +","+DatosTabla.COLUMNA_LOTE  +" FROM Datos WHERE "+ dato + "= ?";
        Cursor c = db.rawQuery(sql, args);
        return c;
    }





}
