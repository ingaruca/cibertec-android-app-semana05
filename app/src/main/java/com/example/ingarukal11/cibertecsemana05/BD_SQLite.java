package com.example.ingarukal11.cibertecsemana05;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BD_SQLite extends SQLiteOpenHelper {

    public BD_SQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table usuario(_ID integer primary key autoincrement, nombre text, direccion text, correo text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void abrir(){
        this.getWritableDatabase();
    }

    public void cerrar(){
        this.close();
    }

    public void insertarRegistro(String nombre, String direccion, String correo){
        ContentValues valores = new ContentValues();

        valores.put("nombre", nombre);
        valores.put("direccion", direccion);
        valores.put("correo", correo);

        this.getWritableDatabase().insert("usuario", null, valores);
    }

    public Cursor listarUsuarios(){
        Cursor cursor = this.getReadableDatabase().query("usuario", new String[]{"_ID", "nombre", "direccion", "correo"},
                null, null, null, null, null);

        if(cursor!=null)
            cursor.moveToFirst();

        return cursor;
    }

    public void eliminarUsuario(int codigo){
        this.getWritableDatabase().delete("usuario", "_ID"+codigo, null);
    }

    public void modificarUsuario(int codigo, String nombre, String direccion, String correo){
        ContentValues valores = new ContentValues();

        valores.put("nombre", nombre);
        valores.put("direccion", direccion);
        valores.put("correo", correo);

        this.getWritableDatabase().update("usuario", valores, "_ID"+codigo, null);
    }

}
