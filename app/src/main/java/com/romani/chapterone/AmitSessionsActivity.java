package com.romani.chapterone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class AmitSessionsActivity extends AppCompatActivity
{

    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;

    // This method is called when the second activity finishes
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        // Check that it is the SecondActivity with an OK result
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE)
        {
            if (resultCode == RESULT_OK)
            {
                // Get String data from Intent
                String returnString = data.getStringExtra("keyName");

                // Set text view with string
                TextView textView = findViewById(R.id.resultDataText);
                textView.setText(returnString);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amit_sessions_activity);
    }

    public void showSession1(View v)
    {
        startActivity(new Intent("com.romani.chapterone.Session1Activity"));
    }
    public void showSession2(View v)
    {
        startActivity(new Intent("com.romani.chapterone.Session2Activity"));
    }

    public void showSession3(View v)
    {
        startActivity(new Intent("com.romani.chapterone.Session3Activity"));
    }

    public void showSession4(View v)
    {
        // Start the SecondActivity
        Intent intent = new Intent(this, Session4Activity.class);
        startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
    }

    public void showSession5(View v)
    {
        Intent i = new Intent(AmitSessionsActivity.this, Session5Activity.class);
        startActivity(i);
    }

    public void showSession6(View v)
    {
        Intent i = new Intent(AmitSessionsActivity.this, Session6Activity.class);
        startActivity(i);
    }

    public void showSession7(View v)
    {
        Intent i = new Intent(AmitSessionsActivity.this, Session7Activity.class);
        startActivity(i);
    }

    public void showSession8(View v)
    {
        Intent i = new Intent(AmitSessionsActivity.this, Session8Activity.class);
        startActivity(i);
    }

    public void showSession8_1(View v)
    {
        Intent i = new Intent(AmitSessionsActivity.this, Session8_1Activity.class);
        startActivity(i);
    }



    public void showSession9(View v)
    {
        Intent i = new Intent(AmitSessionsActivity.this, Session9Activity.class);
        startActivity(i);
    }

    public void showSession10(View v)
    {
        Intent i = new Intent(AmitSessionsActivity.this, Session10Activity.class);
        startActivity(i);
    }
}
