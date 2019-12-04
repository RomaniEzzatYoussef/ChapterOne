package com.romani.chapterone;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Point1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.point1_activity);

        Handler handler = new Handler();
        Runnable r = new Runnable()
        {
            TextView txt = findViewById(R.id.romani_textView);
            Handler handler = new Handler();
            @Override
            public void run ()
            {
                String myColor = "#";

                for (int i = 0; i < 6; i++) {
                    int r = (int) (Math.random() * 2);

                    if (r == 0)
                        myColor += (char) ('0' + (Math.random() * 10));
                    else
                        myColor += (char) ('A' + (Math.random() * 6));
                }

                handler.postDelayed(this , 1500);
                txt.setTextColor(Color.parseColor(myColor));
            }
        };

        handler.postDelayed(r, 1500);
    }
}
