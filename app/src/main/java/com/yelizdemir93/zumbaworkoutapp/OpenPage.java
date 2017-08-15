package com.yelizdemir93.zumbaworkoutapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OpenPage extends AppCompatActivity{

    Button btn_register;
    Button btn_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_page);

        btn_register=(Button)findViewById(R.id.button_register);
        btn_signin = (Button) findViewById(R.id.button_signin);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_reg=new Intent(OpenPage.this,RegisterPage.class);
                startActivity(intent_reg);
            }
        });
        btn_signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                    Intent intent_sig = new Intent(OpenPage.this, SignInPage.class);
                    startActivity(intent_sig);


            }
        });
    }

}
