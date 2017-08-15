package com.yelizdemir93.zumbaworkoutapp;


import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BasalPage extends Fragment{

    View view;
    RadioButton rmal;
    RadioButton rfamal;
    EditText eboy;
    EditText ekilo;
    EditText eyas;
    Button bbasal;
    RadioGroup rGroup;
    TextView tmesaj;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.basal_metabolism, container, false);
        getActivity().setTitle("Basal Metabolism Calculater");

        rmal=(RadioButton) view.findViewById(R.id.r_male);
        rfamal=(RadioButton) view.findViewById(R.id.r_famale);
        eboy=(EditText) view.findViewById(R.id.et_boy);
        ekilo=(EditText) view.findViewById(R.id.et_kilo);
        eyas=(EditText) view.findViewById(R.id.et_yas);
        bbasal=(Button) view.findViewById(R.id.button_basal);
        rGroup=(RadioGroup) view.findViewById(R.id.id_radioGroupBasal);
        tmesaj=(TextView) view.findViewById(R.id.text_mesaj) ;


        bbasal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                double weight;
                double height;
                double basal;
                double yas;
                double sonuc=0;
                if(eboy.getText().toString().isEmpty() || ekilo.getText().toString().isEmpty() || eyas.getText().toString().isEmpty())
                {
                    Toast.makeText(BasalPage.this.getActivity(),"No valid values ! ",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    weight = Double.parseDouble(ekilo.getText().toString());
                    height = Double.parseDouble(eboy.getText().toString());
                    yas = Double.parseDouble(eyas.getText().toString());
                    if (rfamal.isChecked())
                    {
                       sonuc=655+(9.6*weight)+(1.7*height)-(4.7*yas);
                        tmesaj.setText(String.valueOf(sonuc));
                    }
                    else if (rmal.isChecked())
                    {
                        sonuc=66+(13.75*weight)+(5*height)-(6.8*yas);
                        tmesaj.setText(String.valueOf(sonuc));
                    }

                }

        }
    });
        return view;
    }

}
