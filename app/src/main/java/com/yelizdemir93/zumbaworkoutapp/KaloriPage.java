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

public class KaloriPage extends Fragment{
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.kalori_page, container, false);
        getActivity().setTitle("Burning Calorie Calculater");

        final Button btn_kalori=(Button) view.findViewById(R.id.button_kalori);
        final EditText edt_weight=(EditText) view.findViewById(R.id.et_kilo);
        final EditText edt_sure=(EditText) view.findViewById(R.id.et_sure);
        final TextView edt_sonuc=(TextView) view.findViewById(R.id.tson);

        btn_kalori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double weight;
                double sure;
                double sonuc;

                if(edt_weight.getText().toString().isEmpty() || edt_sure.getText().toString().isEmpty())
                {
                    Toast.makeText(KaloriPage.this.getActivity(),"No valid values ! ",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    weight = Double.parseDouble(edt_weight.getText().toString());
                    sure = Double.parseDouble(edt_sure.getText().toString());
                     sonuc=7.5*(sure/60*1)*weight;
                    edt_sonuc.setText(String.valueOf(sonuc));
                }
            }
        });
        return view;


    }
}
