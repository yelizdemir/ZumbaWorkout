package com.yelizdemir93.zumbaworkoutapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPage extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

    }

    public void onClick(View v)
    {
        if (v.getId() == R.id.bRegister)
        {
            EditText et_Name = (EditText) findViewById(R.id.etName);
            EditText et_UserName = (EditText) findViewById(R.id.etUsername);
            EditText et_Mail = (EditText) findViewById(R.id.etMail);
            EditText et_Password = (EditText) findViewById(R.id.etPassword);
            EditText et_ConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);

            String namestr = et_Name.getText().toString();
            String unamestr = et_UserName.getText().toString();
            String emailstr = et_Mail.getText().toString();
            String pass1str = et_Password.getText().toString();
            String pass2str = et_ConfirmPassword.getText().toString();


             if (namestr.isEmpty() || unamestr.isEmpty() || emailstr.isEmpty() || pass1str.isEmpty() || pass2str.isEmpty())
            {
                Toast.makeText(RegisterPage.this, "Missing Information", Toast.LENGTH_SHORT) .show();
                return;
            }
             else if (!pass1str.equals(pass2str)) {
                 Toast pass = Toast.makeText(RegisterPage.this, "Password don't match!", Toast.LENGTH_SHORT);
                 pass.show();
             }
            else
            {
                //insert the detailes in database
                DB db= new DB(RegisterPage.this);
                db.addKisi(namestr,emailstr,unamestr,pass1str);
                finish();
                Intent intent_reg = new Intent(RegisterPage.this, SignInPage.class);
                startActivity(intent_reg);

            }
        }
    }

}






