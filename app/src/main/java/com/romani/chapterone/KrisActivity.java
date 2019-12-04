package com.romani.chapterone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class KrisActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kris_activity);
    }

    public void showActivity4(View v)
    {
        startActivity(new Intent("com.romani.chapterone.RandomActivity"));
    }
}
