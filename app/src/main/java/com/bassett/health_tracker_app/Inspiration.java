package com.bassett.health_tracker_app;

import android.content.Intent;
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

public class Inspiration extends AppCompatActivity {

    int[] nameList = {R.drawable.stronghands,
            R.drawable.fastfinger,
            R.drawable.jpgfinger
    };
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspiration);

        // Get the Intent that started this activity and extract the string
//        Intent intent = getIntent();
//        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
//
//        // Capture the layout's TextView and set the string as its text
//        TextView textView = findViewById(R.id.textView3);
//        textView.setText(message);


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
}
