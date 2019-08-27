package com.example.sqllitelogintask.sql;

public class Tables {

    public static class Student {
        public static final String TABLE_NAME = "student";
        public static final String CREATE_PRODUCT_TABLE =
                "CREATE TABLE student" +
                        "(" +
                        "studentId integer primary key autoincrement," +
                        "studentName text," +
                        "phonenumber text," +
                        "password text"+
                        ")";

        public static class Columns {
            public static final String STUDENT_ID = "studentId",
                    STUDENT_NAME = "studentName",
                    PHONE_NUMBER = "phonenumber",
                    PASSWORD="password";

        }
    }

}
