package com.example.ingarukal11.cibertecsemana05;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarUsuarios extends AppCompatActivity {

    ListView listUsuarios;
    BD_SQLite bd = new BD_SQLite(this, "usuario", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuarios);

        listUsuarios = (ListView)findViewById(R.id.listUsuarios);

        Cursor cursor;
        bd.abrir();

        cursor = bd.listarUsuarios();

        ArrayList<String> lista = new ArrayList<String>();
        String registro = "";

        do {
            registro = cursor.getInt(0)+"-"+
                        cursor.getString(1)+"-"+
                        cursor.getString(2)+"-"+
                        cursor.getString(3);
            lista.add(registro);
        }
        while (cursor.moveToNext());

        ArrayAdapter<String> adap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listUsuarios.setAdapter(adap);
    }
}
