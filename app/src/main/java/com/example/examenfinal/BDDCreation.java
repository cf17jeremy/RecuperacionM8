package com.example.examenfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;

public class BDDCreation extends SQLiteOpenHelper {
    public static final int DBD_Version = 1;
    public static final String BDD_Nom = "weather.db";

    private static final String Creacion_Entradas_SQL = "CREATE TABLE Weather ( ID INTEGER PRIMARY KEY AUTOINCREMENT, City TEXT)";


    public BDDCreation(Context context) {
        super(context, BDD_Nom, null, DBD_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Creacion_Entradas_SQL);
        Log.d("Jertox ANOUNCE","Database created!!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static void insertCity(SQLiteDatabase db, String ct){
        //Check the bd is open
        if (db.isOpen()){
            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the city getting all values
            values.put("City", ct);

            db.insert("Weather", null, values);
        }else{
            Log.d("sql","BDD cerrada");
        }
    }
}