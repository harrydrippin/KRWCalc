package com.kmucs.krwcalc.lib;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * DBManager.java
 * @author Seunghwan Hong
 */
public class DBManager extends SQLiteOpenHelper {

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Card( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, cardcompany INTEGER, netcompany INTEGER, special INTEGER, check INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Not needed
    }

    public void query(String query) {
        try {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(query);
            db.close();
        } catch(Exception e) {
            Log.e("KRWCalcDB", "Query Error : " + query);
        }
    }

    public String getData() {
        try {
            SQLiteDatabase db = getReadableDatabase();
            String str = "";

            Cursor cursor = db.rawQuery("select * from Card", null);
            while (cursor.moveToNext()) {
                str += cursor.getString(1)
                        + ","
                        + cursor.getInt(2)
                        + ","
                        + cursor.getInt(3)
                        + "#";
            }

            return str;
        } catch(Exception e) {
            Log.e("KRWCalcDB", "getCardData() Error");
            return null;
        }


    }
}