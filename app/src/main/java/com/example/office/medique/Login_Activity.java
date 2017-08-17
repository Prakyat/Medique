package com.example.office.medique;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener  {

    private EditText editTextUsername, editTextPassword;
    private Button buttonLogin;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        if (sharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, home_screen.class));
            return;
        }
        editTextUsername = (EditText) findViewById(R.id.edithospitalname);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait");
        buttonLogin.setOnClickListener(this);
    }
    public void userLogin()
    {

       if(editTextUsername.length()==0 || editTextPassword.length()==0)
       {
           Toast.makeText(this,"Please enter all fields",Toast.LENGTH_LONG).show();
       }
       else
       {
           String hospname = getIntent().getExtras().getString("hospname");
           String password = getIntent().getExtras().getString("passwrd");
           String password2=editTextPassword.getText().toString();
           String username2=editTextUsername.getText().toString();

           if(hospname.equals(username2) && password.equals(password2))
           {
               startActivity(new Intent(Login_Activity.this,home_screen.class));
           }
           else
           {
               Toast.makeText(this,"Incorrect details",Toast.LENGTH_LONG).show();
           }
       }
    }




    @Override
    public void onClick(View v) {
        if (v == buttonLogin) {
            userLogin();
        }

    }
}
