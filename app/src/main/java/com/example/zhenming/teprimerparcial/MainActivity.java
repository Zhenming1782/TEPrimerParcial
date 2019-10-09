package com.example.zhenming.teprimerparcial;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button Ingresar,Registrar;

    EditText et1,et2;
    private Cursor fila;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1= (EditText) findViewById(R.id.etusuario);
        et2= (EditText) findViewById(R.id.etcontrasena);
        Ingresar = findViewById(R.id.blogin);
        Registrar = findViewById(R.id.bregistrar);
        final DBConexion admin=new DBConexion(this,"parcial",null,1);


        Ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDatabase db=admin.getWritableDatabase();
                String usuario=et1.getText().toString();
                String contrasena=et2.getText().toString();
                fila=db.rawQuery("select usuario,contrasena from usuarios where usuario='"+usuario+"' and contrasena='"+contrasena+"'",null);

                if(fila.moveToFirst()==true){
                    String usua=fila.getString(0);
                    String pass=fila.getString(1);
                    if (usuario.equals(usua)&&contrasena.equals(pass)){
                        Intent ven=new Intent(MainActivity.this, Menu.class);
                        startActivity(ven);
                        et1.setText("");
                        et2.setText("");
                    }
                }


            }
        });

        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ven=new Intent(MainActivity.this, Registrar.class);
                startActivity(ven);
            }
        });


    }

}
