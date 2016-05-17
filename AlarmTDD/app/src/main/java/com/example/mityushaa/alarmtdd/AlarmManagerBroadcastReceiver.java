package com.example.mityushaa.alarmtdd;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.widget.Toast;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mityushaa on 18.05.2016.
 */
public class AlarmManagerBroadcastReceiver extends BroadcastReceiver {
    final public static String ONE_TIME="onetime";
    @Override
    public void onReceive(Context context, Intent intent) {
        PowerManager pm=(PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl= pm.newWakeLock(PowerManager.FULL_WAKE_LOCK,"WAKE UP FAGGOT");
        wl.acquire();

        Bundle extras= intent.getExtras();
        StringBuilder msgStr=new StringBuilder();

        if(extras!=null&& extras.getBoolean(ONE_TIME, Boolean.FALSE)){

            msgStr.append("One time alarm: ");
        }
        else msgStr.append("Repeating alarm: ");
        Format formatter=new SimpleDateFormat("hh:mm:ss a");
        msgStr.append(formatter.format(new Date()));
        Uri alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        MediaPlayer mp = MediaPlayer.create(context, alert);
        if(mp !=null) {
            mp.setVolume(100, 100);
            mp.start();
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.release();
                }
            });
        }
        //Vibrator vibrator = (Vibrator) context.getSystemService(VIBRATOR_SERVICE);
        //vibrator.vibrate(400);

        Toast.makeText(context, msgStr, Toast.LENGTH_LONG).show();

        wl.release();
    }
    public boolean setOnetimeTimer(Context context){
        return true;
    }
}