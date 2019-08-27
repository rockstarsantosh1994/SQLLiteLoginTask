package com.example.sqllitelogintask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sqllitelogintask.sql.DBHelper;

public class MainActivity extends AppCompatActivity {

    public DBHelper dbHelper;

    public TextView tvId,tvName,tvPhonenumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        Intent intent= getIntent();
        tvId.setText(intent.getStringExtra("id"));
        tvName.setText(intent.getStringExtra("name"));
        tvPhonenumber.setText(intent.getStringExtra("phonenumber"));

    }

    private void init() {
        tvId=findViewById(R.id.tv_id);
        tvName=findViewById(R.id.tv_name);
        tvPhonenumber=findViewById(R.id.tv_phonenumber);

        dbHelper=new DBHelper(MainActivity.this);
    }


}
