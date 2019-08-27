package com.example.sqllitelogintask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.sqllitelogintask.sql.DBHelper;
import com.example.sqllitelogintask.sql.StudentModel;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    public EditText etUsername,etPassword;
    public Button btnLogin,btnSignup;
    public DBHelper dbHelper;
    public StudentModel studentModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        etUsername=findViewById(R.id.et_username);
        etPassword=findViewById(R.id.et_password);
        btnLogin=findViewById(R.id.btn_login);
        btnSignup=findViewById(R.id.btn_signup);

        dbHelper=new DBHelper(this);
        studentModel=new StudentModel(this);

        btnLogin.setOnClickListener(this);
        btnSignup.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_login:String phonenumber=etUsername.getText().toString();
                                String password=etPassword.getText().toString();

                                //Boolean isSuccess=dbHelper.getData(phonenumber,password);
                                Boolean isSuccess=studentModel.getLoginCredential(phonenumber,password);
                                if(isSuccess){
                                    //true login successful
                                    Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                                }else{
                                    Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                                }
                                break;

            case R.id.btn_signup:Intent intent=new Intent(LoginActivity.this, SignUpActivity.class);
                                 startActivity(intent);
                                 break;
        }
    }
}
