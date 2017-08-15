package com.yelizdemir93.zumbaworkoutapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;


public class SignInPage extends AppCompatActivity implements TextWatcher, CompoundButton.OnCheckedChangeListener{
    DB helper;
    Button btnSign;
    Button btnReg;
    EditText etUname,etPass;
    CheckBox remember;
    SharedPreferences sharedPreferences; //preferences referansı
    SharedPreferences.Editor editor; //preferences editor nesnesi referansı .prefernces nesnesine veri ekleyip cıkarmak için
    private static final String PREF_NAME = "prefs";
    private static final String KEY_REMEMBER="remember";
    private static final String KEY_USERNAME="username";
    private static final String KEY_PASS="password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_page);
        helper = new DB(this);

        sharedPreferences= getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();  //aynı şekil editor nesnesi oluşturuluyor
        btnSign=(Button)findViewById(R.id.bSignin);
        btnReg=(Button) findViewById(R.id.button_reg);
        etUname=(EditText) findViewById(R.id.etUname);
        etPass=(EditText) findViewById(R.id.etPass);
        remember=(CheckBox) findViewById(R.id.c_remember) ;

        if (sharedPreferences.getBoolean(KEY_REMEMBER, false))
        {
            remember.setChecked(true);
        }
        else
        {
            remember.setChecked(false);
        }
        etUname.setText(sharedPreferences.getString(KEY_USERNAME,""));
        etPass.setText(sharedPreferences.getString(KEY_PASS,""));

        etUname.addTextChangedListener(this);
        etPass.addTextChangedListener(this);
        remember.setOnCheckedChangeListener(this);


        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str=etUname.getText().toString();
                String pass=etPass.getText().toString();

                if(str.matches("") || pass.matches(""))//bilgiler eksik   ise
                {

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(SignInPage.this);
                    alertDialog.setTitle("Warning");
                    alertDialog.setMessage("Fill without Missing !");
                    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    alertDialog.show();
                }
                else
                {
                    boolean isOk = helper.isLoggedIn(str, pass);
                    Log.e("x", "Login Sonucu  : " + isOk);

                    if (isOk)
                    {
                        startActivity(new Intent(SignInPage.this, MainActivity.class));
                    }
                }
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(SignInPage.this, RegisterPage.class));
            }
        });


    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        managePrefs();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        managePrefs();
    }
    private void managePrefs()
    {
        if (remember.isChecked())
        {
            editor.putString(KEY_USERNAME, etUname.getText().toString().trim());
            editor.putString(KEY_PASS, etPass.getText().toString().trim());
            editor.putBoolean(KEY_REMEMBER,true);
            editor.apply();
        }
        else
        {
            editor.putBoolean(KEY_REMEMBER,false);
            editor.remove(KEY_PASS);
            editor.remove(KEY_USERNAME);
            editor.apply();
        }
    }
}

