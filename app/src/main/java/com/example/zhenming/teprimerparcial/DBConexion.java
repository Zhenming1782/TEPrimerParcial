package com.example.zhenming.teprimerparcial;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConexion extends SQLiteOpenHelper {

    public DBConexion(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuarios( codigo integer primary key, usuario text, contrasena text)");
        db.execSQL("insert into usuarios values(1,'admin','admin')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("create table usuarios( codigo integer primary key,usuario text,contrasena text)");
        db.execSQL("insert into usuarios values(1,'admin','admin')");
    }
}
