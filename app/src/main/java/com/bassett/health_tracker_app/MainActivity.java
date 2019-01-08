package com.bassett.health_tracker_app;

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

    private int index = 0;
    public Integer currentCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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
