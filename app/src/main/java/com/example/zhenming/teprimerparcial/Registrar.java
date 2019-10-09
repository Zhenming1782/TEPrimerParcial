package com.example.zhenming.teprimerparcial;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registrar extends AppCompatActivity {

    Button Guardar, Regresar;
    EditText et1,et2,et3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        et1= (EditText) findViewById(R.id.etcodigo);
        et2= (EditText) findViewById(R.id.etusuario);
        et3= (EditText) findViewById(R.id.etcontrasena);
        Guardar = findViewById(R.id.bguardar);
        Regresar = findViewById(R.id.bregresar);
        final DBConexion admin=new DBConexion(this,"parcial",null,1);

        Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db= admin.getWritableDatabase();
                Integer codigo=Integer.parseInt(et1.getText().toString()) ;
                String usuario=et2.getText().toString();
                String contrasena=et3.getText().toString();

                db.execSQL("insert into usuarios values("+codigo.toString()+",'"+usuario+"','"+contrasena+"')");

                db.close();
                finish();
            }
        });

        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
