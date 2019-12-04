package com.romani.chapterone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;


public class MenuActivity extends AppCompatActivity
{
    String tag = "lifecycle step";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        Log.d(tag, "In the onCreate() event ");
    }

    protected void onStart() {
        super.onStart();
        Log.d(tag, "In the onStart() event ");
    }

    protected void onResume() {
        super.onResume();
        Log.d(tag, "In the onResume() event");
    }

    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "In the onRestart() event ");
    }

    protected void onPause() {
        super.onPause();
        Log.d(tag, "In the onPause() event");
    }

    protected void onStop() {
        super.onStop();
        Log.d(tag, "In the onStop() event");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "In the onDestroy() event");
    }

    public void showRomaniActivity(View v)
    {
        startActivity(new Intent("com.romani.chapterone.RomaniMenuActivity"));
    }

    public void showAmitSessions(View v)
    {
        startActivity(new Intent("com.romani.chapterone.AmitSessionsActivity"));
    }
}
