package com.example.sqllitelogintask.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.sqllitelogintask.pojo.StudentData;


public class StudentModel {

    Context context;
    SQLiteDatabase db;
    DBHelper helper;

    public StudentModel(Context context) {
        this.context = context;
         helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }

    public long addStudent(StudentData student) {
        ContentValues values = new ContentValues();
        values.put(Tables.Student.Columns.STUDENT_NAME, student.getName());
        values.put(Tables.Student.Columns.PHONE_NUMBER, student.getPhonenumber());
        values.put(Tables.Student.Columns.PASSWORD, student.getPassword());
        long id = db.insert(Tables.Student.TABLE_NAME, null, values);
        return id;
    }

    public Boolean getLoginCredential(String phonenumber,String password) {
        db = helper.getReadableDatabase();
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
