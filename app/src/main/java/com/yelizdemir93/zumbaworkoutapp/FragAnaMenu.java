package com.yelizdemir93.zumbaworkoutapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class FragAnaMenu extends Fragment
{
    View root;

    ImageView b1, b2, b3, b4, b5, b6;

    MainActivity ma;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.anamenu, container, false);
        getActivity().setTitle("Main Page");

        ma = (MainActivity) getActivity();
        b1 = (ImageView) root.findViewById(R.id.ib_pedometer);
        b2 = (ImageView) root.findViewById(R.id.ib_zumba);
        b3 = (ImageView) root.findViewById(R.id.ib_kalori);
        b4 = (ImageView) root.findViewById(R.id.ib_bmi);
        b5 = (ImageView) root.findViewById(R.id.ib_basal);
        b6 = (ImageView) root.findViewById(R.id.ib_ideal);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PedometerPage pp=new PedometerPage();
                ma.gotoFragment(pp, true);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ZumbaPage zp=new ZumbaPage();
                ma.gotoFragment(zp, true);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KaloriPage kp = new KaloriPage();
                ma.gotoFragment(kp, true);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BMIPage bmi = new BMIPage();
                ma.gotoFragment(bmi, true);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasalPage bp=new BasalPage();
                ma.gotoFragment(bp, true);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IdealPage ip = new IdealPage();
                ma.gotoFragment(ip, true);
            }
        });
        return root;
    }
}
