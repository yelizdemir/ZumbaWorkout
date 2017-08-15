package com.yelizdemir93.zumbaworkoutapp;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class Alarm_Receiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent ıntent) {

        Log.e("Alarm reciever","yayyy");

        Bildirim b=new Bildirim();
       // b.goster(context,"Reminder","Time to Zumba...");
        PendingIntent pi =
                PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0);

        b.gosterWithBildirim(context, "Reminder", "Time to Zumba", pi);
    }
}
