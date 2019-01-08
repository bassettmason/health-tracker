package com.bassett.health_tracker_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public Integer currentCount = 0;
    public void onButtonClick(View v) {
        System.out.println("button was clicked");
        TextView textView  = findViewById(R.id.textView);
        currentCount = currentCount + 1;
        String everyTenEncouragement = " good job keep it up";
        String everyFiftyEncouragement = " omg you are amazing";
        if (currentCount % 10 == 0 && currentCount % 50 != 0) {
            String currentCountString = currentCount.toString();
            textView.setText(currentCountString + everyTenEncouragement);
        }else if (currentCount % 50 == 0) {
            String currentCountString = currentCount.toString();
            textView.setText(currentCountString + everyFiftyEncouragement);
        }else {
            String currentCountString = currentCount.toString();
            textView.setText(currentCountString);
        }

    }
}
