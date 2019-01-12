package com.bassett.health_tracker_app;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    public static final String life = "hello world";

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
