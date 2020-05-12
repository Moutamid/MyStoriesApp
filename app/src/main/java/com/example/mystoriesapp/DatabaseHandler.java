package com.example.mystoriesapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {
    private ArrayList<String> COLUMN_NAMES = new ArrayList<>();
    private String DATABASE_TABLE_NAME;

    public DatabaseHandler(Context context, String database_name, String table_name, ArrayList<String> column_names) {
        super(context, database_name, null, 1);
        this.DATABASE_TABLE_NAME = table_name;
        this.COLUMN_NAMES = column_names;
    }

    public void onCreate(SQLiteDatabase db) {
        StringBuilder COLUMNS_STRING = new StringBuilder();
        for (String column_name : this.COLUMN_NAMES) {
            String sb = ", " + column_name + " TEXT";
            COLUMNS_STRING.append(sb);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("create table ");
        sb2.append(this.DATABASE_TABLE_NAME);
        sb2.append("(ID INTEGER PRIMARY KEY AUTOINCREMENT");
        sb2.append(COLUMNS_STRING);
        sb2.append(")");
        db.execSQL(sb2.toString());
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sb = "DROP TABLE IF EXISTS " + this.DATABASE_TABLE_NAME;
        db.execSQL(sb);
        onCreate(db);
    }

    public boolean InsertData(ArrayList<String> dataArrayList) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for (int i = 0; i < this.COLUMN_NAMES.size(); i++) {
            contentValues.put((String) this.COLUMN_NAMES.get(i), (String) dataArrayList.get(i));
        }
        return db.insert(this.DATABASE_TABLE_NAME, null, contentValues) != -1;

        //if (db.insert(this.DATABASE_TABLE_NAME, null, contentValues) == -1) {
        //            return false;
        //        }
        //        return true;
    }

    public boolean updateData(int id, ArrayList<String> dataList) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for (int i = 0; i < this.COLUMN_NAMES.size(); i++) {
            contentValues.put((String) this.COLUMN_NAMES.get(i), (String) dataList.get(i));
        }
        String str = this.DATABASE_TABLE_NAME;
        String sb = "ID=" + id;
        return db.update(str, contentValues, sb, null) > 0;
    }

    public boolean deleteData(long id) {
        SQLiteDatabase db = getWritableDatabase();
        String str = this.DATABASE_TABLE_NAME;
        String sb = "ID=" + id;
        return db.delete(str, sb, null) > 0;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = getWritableDatabase();
        String sb = "select * from " + this.DATABASE_TABLE_NAME;
        return db.rawQuery(sb, null);
    }

    public Cursor getSingleData(long id, String[] columnStringsArray) {
        SQLiteDatabase db = getWritableDatabase();
        String str = this.DATABASE_TABLE_NAME;
        String sb = "ID=" + id;
        Cursor cursor = db.query(true, str, columnStringsArray, sb, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
}
