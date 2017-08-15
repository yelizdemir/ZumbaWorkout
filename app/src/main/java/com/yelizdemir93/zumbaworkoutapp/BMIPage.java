package com.yelizdemir93.zumbaworkoutapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMIPage extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        view=inflater.inflate(R.layout.bmi_page, container,false);
        getActivity().setTitle("BMI Calculater");


        final Button button_calc=(Button) view.findViewById(R.id.bcalculate);
        final EditText e_weight=(EditText) view.findViewById(R.id.et_weight);
        final EditText e_height=(EditText) view.findViewById(R.id.et_h);
        final TextView result=(TextView) view.findViewById(R.id.text_result);
        final TextView t_msg=(TextView) view.findViewById(R.id.text_msg);

        button_calc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                double weight;
                double height;
                double bmi;
                String msg="";

                if(e_height.getText().toString().isEmpty() || e_weight.getText().toString().isEmpty())
                {
                    Toast.makeText(BMIPage.this.getActivity(),"No valid values ! ",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    weight = Double.parseDouble(e_weight.getText().toString());
                    height = Double.parseDouble(e_height.getText().toString());

                    bmi=height*height;
                    bmi=weight/bmi;
                    result.setText(String.valueOf(bmi));
                    if (bmi < 18.5) msg = "Underweight";
                    else if (bmi > 18.5 && bmi < 25) msg = "Normal";
                    else if (bmi > 25 && bmi < 30) msg = "Overweight";
                    else if (bmi > 30) msg = "Obese";
                    t_msg.setText(msg);
                }
            }
        });

        return view;
    }
}
