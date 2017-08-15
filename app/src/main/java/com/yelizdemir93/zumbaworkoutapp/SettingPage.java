package com.yelizdemir93.zumbaworkoutapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class SettingPage extends Fragment
{
    //to make our alarm manager
    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    TextView update_text;
    Context context;
    PendingIntent pending_intent;


    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.settings, container, false);
        getActivity().setTitle("Settings");
        this.context=getActivity();

        //initialize our alarm manager
        alarm_manager=(AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarm_timepicker=(TimePicker) view.findViewById(R.id.timePicker);
        update_text=(TextView) view.findViewById(R.id.update_text);

        //create an instance of a calendar
        final Calendar calendar = Calendar.getInstance();

            final Intent intent = new Intent(getActivity(), Alarm_Receiver.class);

        Button alarm_on=(Button) view.findViewById(R.id.alarm_on);
        Button alarm_off=(Button) view.findViewById(R.id.alarm_off);

        alarm_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // setting calendar instance with the hour and minute that ve picked
                //on te time picker
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
                    calendar.set(Calendar.MINUTE, alarm_timepicker.getMinute());

                    //get the int valuew of the hour and minute
                    int hour = alarm_timepicker.getHour();
                    int minute = alarm_timepicker.getMinute();

                    //conver the int value of the hour and minute
                    String hour_string=String.valueOf(hour);
                    String minute_string= String.valueOf(minute);

                    //convert 24-hour time to 12-hour time
                    if (hour>12)
                    {
                        hour_string = String.valueOf(hour-12);
                    }
                    if (minute<10)
                    {
                        //10:7 --> 10:07
                        minute_string="0" + String.valueOf(minute);
                    }
                    //method that change the update txt TextBox
                    set_alarm_text("Alarm Set to: "+ hour_string + ":" + minute_string);

                    //create a pending intent that delays the intent
                    //until the specified calendar time
                    pending_intent = PendingIntent.getBroadcast(getActivity(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                    //set the alarm manager
                    alarm_manager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pending_intent);
                }

            }
        });

        alarm_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //method that change the update txt TextBox
                set_alarm_text("Alarm Off");

                // cancel alarm manager
                alarm_manager.cancel(pending_intent);
            }
        });


        return view;
    }

    private void set_alarm_text(String output)
    {
        update_text.setText(output);
    }
}
