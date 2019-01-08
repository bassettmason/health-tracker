package com.bassett.health_tracker_app;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    int[] nameList = {R.drawable.stronghands,
            R.drawable.fastfinger,
            R.drawable.jpgfinger
    };
//  ImageSwitcher
    private int index = 0;
    //button counter
    public Integer currentCount = 0;

    //stopwatch
    public Button startButton, stopButton, resetButton, startStopButton;
    public TextView txtTimer;
    public Handler customHandler = new Handler();
    public long startTime=0L, timeInMilliseconds=0L, updateTime=0L, timeSwapBuff=0l;
    private int checkState = 0;

    public Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis()-startTime;
            updateTime = timeSwapBuff+timeInMilliseconds;
            int secs=(int) (updateTime/1000);
            int mins= secs/60;
            secs%=60;
            int milliseconds=(int)(updateTime%1000);
            txtTimer.setText(""+ mins + ":" + String.format("%2d",secs) + ":" + String.format("%3d", milliseconds));
            customHandler.postDelayed(this,0);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startStopButton = findViewById(R.id.startStopButton);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);
        resetButton = findViewById(R.id.resetButton);
        txtTimer = findViewById(R.id.timerValue);

        startStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkState == 0) {
                    startStopButton.setText("start");
                    startTime = SystemClock.uptimeMillis();

                    customHandler.postDelayed(updateTimerThread, 0);
                    checkState = 1;
                }
                // pause
                else {
                    startStopButton.setText("stop");
                    timeSwapBuff += timeInMilliseconds;
                    customHandler.removeCallbacks(updateTimerThread);
                    checkState = 0;
                }
                startTime = SystemClock.uptimeMillis();

                customHandler.postDelayed(updateTimerThread, 0);
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTime = SystemClock.uptimeMillis();

                customHandler.postDelayed(updateTimerThread, 0);
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeSwapBuff += timeInMilliseconds;
                customHandler.removeCallbacks(updateTimerThread);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.timerValue);

                textView.setText("0:00:000");

            }
        });



        final ImageSwitcher imageSwitcher = findViewById(R.id.imageSwitcher);
        if (imageSwitcher != null) {
            imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
                public View makeView() {
                    ImageView imageView = new ImageView(getApplicationContext());
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imageView.setLayoutParams(new
                            ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));

                    return imageView;
                }
            });

            imageSwitcher.setImageResource(nameList[index]);

            Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
            imageSwitcher.setInAnimation(in);

            Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
            imageSwitcher.setOutAnimation(out);
        }

        Button button2 = findViewById(R.id.button2);
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    index = (++index < nameList.length) ? index : 0;
                    if (imageSwitcher != null) {
                        imageSwitcher.setImageResource(nameList[index]);
                    }
                    TextView textView2 = findViewById(R.id.textView2);

                    textView2.setText("this is " + "custom pic caption");
                }
            });
        }

    }
    public void onButtonClick (View v){
        System.out.println("button was clicked");
        TextView textView = findViewById(R.id.textView);
        currentCount = currentCount + 1;
        String everyTenEncouragement = " good job keep it up ";
        String everyFiftyEncouragement = " omg you are amazing";
        if (currentCount % 10 == 0 && currentCount % 50 != 0) {
            String currentCountString = currentCount.toString();
            textView.setText(currentCountString + everyTenEncouragement);
        } else if (currentCount % 50 == 0) {
            String currentCountString = currentCount.toString();
            textView.setText(currentCountString + everyFiftyEncouragement);
        } else {
            String currentCountString = currentCount.toString();
            textView.setText(currentCountString);
        }

    }
}
