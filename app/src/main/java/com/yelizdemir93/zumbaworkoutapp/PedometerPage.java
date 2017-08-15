package com.yelizdemir93.zumbaworkoutapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class PedometerPage extends Fragment implements SensorEventListener {
    View view;
    TextView tv_steps;
    SensorManager sensorManager;
    boolean running=false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        view=inflater.inflate(R.layout.pedometer_page, container,false);
        getActivity().setTitle("Pedometer");

        tv_steps=(TextView) view.findViewById(R.id.tv_steps);
        sensorManager=(SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        return view;
    }
    @Override
    public void onResume(){
        super.onResume();
        running=true;
        Sensor countSensor=sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (countSensor != null)
        {
            sensorManager.registerListener(this,countSensor,SensorManager.SENSOR_DELAY_UI);

        }
        else Toast.makeText(PedometerPage.this.getActivity(), "!!!!! ",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause()
    {
        super.onPause();
        running=false;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        Log.e("x", Arrays.toString(sensorEvent.values));
        tv_steps.setText(""+(int)sensorEvent.values[0]); //adım göster
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
