package com.example.sqllitelogintask.sql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    final static int version = 1;
    static final String name = "studentDb";
    Context context;

    public DBHelper(Context context) {
        super(context, name, null, version);
        this.context=context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(Tables.Student.CREATE_PRODUCT_TABLE);
        } catch(SQLiteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Boolean getData(String phonenumber,String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data =  db.rawQuery( "select * from student where phonenumber='"+phonenumber+"' and password='"+password+"'", null );
        if(data.getCount()!=0 && data.getColumnCount()>0){
            data.moveToFirst();

            data.getString(data.getColumnIndex(Tables.Student.Columns.STUDENT_ID));
            data.getString(data.getColumnIndex(Tables.Student.Columns.STUDENT_NAME));
            data.getString(data.getColumnIndex(Tables.Student.Columns.PHONE_NUMBER));
            return true;
        }else{
            return false;
        }
    }
}
