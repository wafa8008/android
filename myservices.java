package com.example.audioplayer;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import java.io.File;
import java.io.IOException;

public class myservices extends Service {

    public static final String CHANNEL_ID = "ForegroundServiceChannel";

    private MediaPlayer player = null;
    private Uri audioFileUri = null;
    public static final String ACTION_START_FOREGROUND_SERVICE = "ACTION_START_FOREGROUND_SERVICE";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            if (intent != null) {
                String action = intent.getAction();
                switch (action) {
                    case ACTION_START_FOREGROUND_SERVICE:
                        audioFileUri = Uri.parse(intent.getStringExtra("inputExtra"));
                        startForegroundService();
                        break;

                }
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        return START_STICKY;
    }

    private void startForegroundService() {

        try {
            if (player == null) {
                createNotificationChannel();
                Intent notificationIntent = new Intent(this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this,
                        0, notificationIntent, 0);

                Notification notification =new NotificationCompat.Builder(this,CHANNEL_ID)
                        .setContentTitle("Foreground Service")

                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentIntent(pendingIntent)
                        .build();

                startForeground(1, notification);

                player = new MediaPlayer();
                if (audioFileUri != null) {
                    player.setDataSource(getApplicationContext(), audioFileUri);
                }

                player.prepare();
                player.setLooping(true);
                player.start();

            }else {
                player.stop();
                player = new MediaPlayer();
                if (audioFileUri != null) {
                    player.setDataSource(getApplicationContext(), audioFileUri);
                }
                player.prepare();
                player.setLooping(true);
                player.start();
            }
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
    }


    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Foreground Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
        }
    }
}



