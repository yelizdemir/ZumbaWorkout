package com.yelizdemir93.zumbaworkoutapp;


import android.os.Bundle;
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

public class IdealPage extends Fragment{

    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ideal_page, container, false);
        getActivity().setTitle("Ideal Weight Calculater");

       final RadioButton rmale=(RadioButton) view.findViewById(R.id.radio_male);
        final RadioButton rfamale=(RadioButton) view.findViewById(R.id.radio_famale);
        final EditText  eboy=(EditText) view.findViewById(R.id.et_he);
        final TextView tmessage=(TextView)  view.findViewById(R.id.text_message);
        final Button buttonideal=(Button) view.findViewById(R.id.button_ideal);
        final RadioGroup rG=(RadioGroup) view.findViewById(R.id.id_radioGroupIdeal) ;

        buttonideal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                double height;
                int idealKilo;

                if(eboy.getText().toString().isEmpty() || rfamale.getText().toString().isEmpty() || rmale.getText().toString().isEmpty())
                {
                    Toast.makeText(IdealPage.this.getActivity(),"No valid values ! ",Toast.LENGTH_SHORT).show();
                }
                else
                {

                    height = Double.parseDouble(eboy.getText().toString());

                    if (rfamale.isChecked())
                    {
                        idealKilo=(int)(45.5+2.3*(height*100*0.4-60));
                        tmessage.setText(String.valueOf(idealKilo));
                    }
                    else if(rmale.isChecked())
                    {
                        idealKilo=(int)(50+2.3*(height*100*0.4-60));
                        tmessage.setText(String.valueOf(idealKilo));
                    }

                }

            }
        });
        return view;
    }

}
