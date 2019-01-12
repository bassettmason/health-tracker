package com.bassett.health_tracker_app;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "channelId";
    public static final String life = "hello world";

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onNotificationClick(View v){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.notificationbell)
                .setContentTitle("Title")
                .setContentText("text")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("bigtext"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        notificationManager.notify(1,mBuilder.build());
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notifications";
            String description = "notifications stuff";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void sendToInspiration(View v) {
        Intent intent = new Intent(this, Inspiration.class);
        String message = "Inspiration";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void sendToFingerExercise(View v) {
        Intent intent = new Intent(this, FingerExercise.class);
        String message = "Finger Exercise";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void sendToStopwatch(View v) {
        Intent intent = new Intent(this, Stopwatch.class);
        String message = "Stopwatch";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


}
