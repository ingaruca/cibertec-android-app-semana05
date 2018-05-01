package com.example.ingarukal11.cibertecsemana05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre, txtDireccion, txtCorreo;
    Button btnGrabar, btnListar, btnEditar, btnEliminar;

    BD_SQLite bd = new BD_SQLite(this, "usuario", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText)findViewById(R.id.txtNombre);
        txtDireccion = (EditText)findViewById(R.id.txtDireccion);
        txtCorreo = (EditText)findViewById(R.id.txtCorreo);
        btnGrabar = (Button)findViewById(R.id.btnGrabar);
        btnListar = (Button)findViewById(R.id.btnListar);
        btnEditar = (Button)findViewById(R.id.btnEditar);
        btnEliminar = (Button)findViewById(R.id.btnEliminar);

        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bd.abrir();
                bd.insertarRegistro(txtNombre.getText().toString(),
                                    txtDireccion.getText().toString(),
                                    txtCorreo.getText().toString());
                bd.cerrar();

                txtNombre.setText(null);
                txtDireccion.setText(null);
                txtCorreo.setText(null);

                Toast.makeText(getApplicationContext(), "Usuario Grabado",
                        Toast.LENGTH_LONG).show();
            }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ListarUsuarios.class);
                startActivity(i);
            }
        });
    }
}
