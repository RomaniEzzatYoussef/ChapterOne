package com.romani.chapterone;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class RomaniMenuActivity extends AppCompatActivity implements View.OnClickListener
{
    LinearLayout sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.romani_menu_activity);
        sv = findViewById(R.id.linearParent);



        Handler handler = new Handler();
        Runnable r = new Runnable()
        {
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
                //sv.setBackgroundColor(Color.parseColor(myColor));
            }
        };

        handler.postDelayed(r, 1500);
    }

    @Override
    public void onClick(View v) {


    }

    public void showFileActivity(View v) {
        startActivity(new Intent("com.romani.chapterone.FileActivity"));
    }

    public void showRandomActivity(View v) {
        startActivity(new Intent("com.romani.chapterone.RandomActivity"));
    }

    public void changeViewButton(View v) {
        Button b = findViewById(R.id.changeViewbutton);
        b.setBackgroundColor(Color.BLUE);
        b.setText("Clicked");
    }

    public void showKrisActivity(View v) {
        startActivity(new Intent("com.romani.chapterone.KrisActivity"));
    }

    public void showLoginActivity(View v) {
        startActivity(new Intent("com.romani.chapterone.LoginActivity"));
    }

    public void showHexActivity(View v) {
        startActivity(new Intent("com.romani.chapterone.HexadecimalActivity"));
    }

    public void showEditFileActivity(View v) {
        startActivity(new Intent("com.romani.chapterone.EditFileActivity"));
    }

    public void startPoint1Activity(View v)
    {
        Intent i = new Intent(RomaniMenuActivity.this , Point1Activity.class);
        startActivity(i);
    }

    public void startPoint2Activity(View v)
    {
        Intent i = new Intent(RomaniMenuActivity.this , Point2Activity.class);
        startActivity(i);
    }

    public void startPoint3Activity(View v)
    {
        startActivity(new Intent("com.romani.chapterone.Point3Activity"));
    }


}
