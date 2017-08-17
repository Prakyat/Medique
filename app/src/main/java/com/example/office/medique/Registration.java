package com.example.office.medique;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    EditText EditTextHospital, EditTextAddress, EditTextCity, EditTextState, EditTextCountry, EditTextPinCode, EditTextMobile, EditTextTelephone, EditTextEmailId, password;
    Button register;
    String name, address, city, country, state, telephone, mobile, pincode, email, passwrd;
    boolean isEmpty = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        EditTextHospital = (EditText) findViewById(R.id.edit_hospitalname);
        EditTextAddress = (EditText) findViewById(R.id.edit_Address);
        EditTextState = (EditText) findViewById(R.id.edit_State);
        EditTextCountry = (EditText) findViewById(R.id.edit_Country);
        EditTextTelephone = (EditText) findViewById(R.id.edit_telephone);
        EditTextMobile = (EditText) findViewById(R.id.edit_mobile);
        EditTextPinCode = (EditText) findViewById(R.id.edit_pincode);
        EditTextEmailId = (EditText) findViewById(R.id.edit_Email);
        EditTextCity = (EditText) findViewById(R.id.edit_City);
        password = (EditText) findViewById(R.id.edit_password);
        register = (Button) findViewById(R.id.registerbttn);
        boolean isEmpty = false;


    }

    public void register(View view) {
        name = EditTextHospital.getText().toString();
        address = EditTextHospital.getText().toString();
        city = EditTextAddress.getText().toString();
        country = EditTextState.getText().toString();
        state = EditTextCountry.getText().toString();
        telephone = EditTextCity.getText().toString();
        mobile = EditTextPinCode.getText().toString();
        pincode = EditTextMobile.getText().toString();
        email = EditTextTelephone.getText().toString();
        passwrd = password.getText().toString();
        int[] ids = new int[]
                {R.id.edit_hospitalname,
                        R.id.edit_Address,
                        R.id.edit_State,
                        R.id.edit_Country,
                        R.id.edit_telephone,
                        R.id.edit_mobile,
                        R.id.edit_pincode,
                        R.id.edit_Email,
                        R.id.edit_City
                };
        for (int id : ids) {
            EditText et = (EditText) findViewById(id);

            if (TextUtils.isEmpty(et.getText().toString())) {
                et.setError("Must enter Value");
                isEmpty = true;
            }
            else
            {
                isEmpty = false;
            }
        }
        if(isEmpty==false) {


            sharedPrefManager.getInstance(getApplicationContext()).hospitalDetails(name, passwrd);
            Intent loggedInIntent = new Intent(Registration.this, Login_Activity.class);
            loggedInIntent.putExtra("hospname", name);
            loggedInIntent.putExtra("passwrd", passwrd);
            startActivity(loggedInIntent);
        }
        else
        {
            Toast.makeText(this,"please fill all the fields to continue", Toast.LENGTH_LONG).show();
        }

    }

    public boolean validateEditText(int[] ids) {
        boolean isEmpty = false;

        for (int id : ids) {
            EditText et = (EditText) findViewById(id);

            if (TextUtils.isEmpty(et.getText().toString())) {
                et.setError("Must enter Value");
                isEmpty = true;
            }
        }

        return isEmpty;
    }
}