package com.bassett.health_tracker_app;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;



public class MainActivity extends AppCompatActivity {
//    public static final String CHANNEL_ID = "channelId";
    public static final String life = "hello world";

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String CHANNEL_ID = "channelId";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       createNotificationChannel();

        findViewById(R.id.sendNotification).setOnClickListener((new View.OnClickListener() {
            //from https://www.youtube.com/watch?v=1fV9NmvxXJo tutorial
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                //test the notification time to what you want
//                calendar.set(Calendar.HOUR_OF_DAY,1);
//                calendar.set(Calendar.MINUTE,29);
//                calendar.set(Calendar.SECOND,30);

                Intent intent = new Intent(getApplicationContext(),Notification_receiver.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),180,intent,PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_FIFTEEN_MINUTES,pendingIntent);
            }
        }));



    }



    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notifications";
            String description = "Notifications stuff";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void sendToExerciseDiary(View v) {
        Intent intent = new Intent(this, ExerciseDiary.class);
//        String message = "Inspiration";
//        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void sendToInspiration(View v) {
        Intent intent = new Intent(this, Inspiration.class);
//        String message = "Inspiration";
//        intent.putExtra(EXTRA_MESSAGE, message);
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
