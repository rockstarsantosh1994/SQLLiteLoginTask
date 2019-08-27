package com.example.sqllitelogintask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqllitelogintask.pojo.StudentData;
import com.example.sqllitelogintask.sql.StudentModel;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText etName, etMobileNumber, etPassword, etConfirmPass;
    public Button btnSignup, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initView();
    }

    private void initView() {
        etName = findViewById(R.id.et_name);
        etMobileNumber = findViewById(R.id.et_mobile_number);
        etPassword = findViewById(R.id.et_password);
        etConfirmPass = findViewById(R.id.et_confirmpassword);
        btnSignup = findViewById(R.id.btn_signup);
        btnLogin = findViewById(R.id.btn_login);

        btnSignup.setOnClickListener(this);
        btnLogin.setOnClickListener(this);


    }


    private boolean idValidated() {

        if (etName.getText().toString().length() == 0) {
            etName.setError("Please enter Name.");
            return false;
        }

        if (etMobileNumber.getText().toString().length() == 0) {
            etMobileNumber.setError("Please enter mobile no.");
            return false;
        }

        if (etMobileNumber.getText().toString().length() != 10) {
            etMobileNumber.setError("Please enter valid mobile no.");
            return false;
        }


        if (etPassword.getText().toString().length() == 0) {
            etPassword.setError("Please enter Password.");
            return false;
        }
        if (!etPassword.getText().toString().equals(etConfirmPass.getText().toString())) {
            etConfirmPass.setError("Password is not matching");
            etConfirmPass.setFocusable(true);
            return false;
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        //  int id=v.getId();

        switch (v.getId()) {
            case R.id.btn_signup:

                if (idValidated()) {
                    Toast.makeText(this, "Clicked on Event", Toast.LENGTH_SHORT).show();
                    String studentName = etName.getText().toString();
                    String phonenumber = etMobileNumber.getText().toString();
                    String password = etPassword.getText().toString();

                    StudentData data = new StudentData(studentName, phonenumber, password);
                    StudentModel studentModel = new StudentModel(SignUpActivity.this);
                    studentModel.addStudent(data);
                    startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                    finish();

                     long  stud_id= studentModel.addStudent(data);
                    Toast.makeText(this, "stud_id"+stud_id, Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, ""+data, Toast.LENGTH_SHORT).show();
                }
                    break;

                    case R.id.btn_login:
                        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                        startActivity(intent);
                        break;
                }
        }
}
