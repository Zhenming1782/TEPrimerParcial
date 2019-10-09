package com.example.zhenming.teprimerparcial;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Registrar extends AppCompatActivity {

    EditText et1,et2,et3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        et1= (EditText) findViewById(R.id.etcodigo);
        et2= (EditText) findViewById(R.id.etusuario);
        et3= (EditText) findViewById(R.id.etcontrasena);
    }

    public void registro(View v){

        DBConexion admin = new DBConexion(this,"parcial",null,1);
        SQLiteDatabase db= admin.getWritableDatabase();
        String codigo=et1.getText().toString();
        String usuario=et2.getText().toString();
        String contrasena=et3.getText().toString();

        ContentValues values = new ContentValues();

        values.put("codigo",codigo);
        values.put("usuario",usuario);
        values.put("contrasena",contrasena);

        db.insert("usuarios",null,values);
        db.close();
        finish();
        //Intent ventana = new Intent(this, MainActivity.class);
        //startActivity(ventana);
    }

    public void salir(View v){
        finish();
    }
}
