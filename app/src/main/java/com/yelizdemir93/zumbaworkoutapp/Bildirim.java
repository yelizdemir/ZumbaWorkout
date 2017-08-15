package com.yelizdemir93.zumbaworkoutapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;


public class Bildirim
{
    public static void goster(Context ctx, String baslik, String icerik)
    {
        NotificationManager nManager = (NotificationManager) ctx.getSystemService(ctx.NOTIFICATION_SERVICE);
        NotificationCompat.Builder nb = new NotificationCompat.Builder(ctx);
        nb.setContentTitle(baslik);
        nb.setContentText(icerik);
        nb.setSmallIcon(R.mipmap.ic_logo);
        Notification n = nb.build();

        nManager.notify(0, n);


    }

    public static void gosterWithBildirim(Context ctx, String baslik, String icerik, PendingIntent pi)
    {
        NotificationManager nManager = (NotificationManager) ctx.getSystemService(ctx.NOTIFICATION_SERVICE);
        NotificationCompat.Builder nb = new NotificationCompat.Builder(ctx);
        nb.setContentTitle(baslik);
        nb.setContentIntent(pi);
        nb.setContentText(icerik);
        nb.setSmallIcon(R.mipmap.ic_logo);
        Notification n = nb.build();

        nManager.notify(0, n);


    }
}
