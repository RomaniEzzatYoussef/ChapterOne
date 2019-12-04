package com.romani.chapterone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class Session2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.session2_activity);

        ImageView iv = findViewById(R.id.imageButton2);
        //iv.setImageResource(R.drawable.common_full_open_on_phone);

        TextView txtView = findViewById(R.id.contentTxtView);
        txtView.setText(R.string.my_content);

        Toast.makeText(this , "Welcome to the first toast message" , Toast.LENGTH_LONG).show();
    }

    public void showToast(View v)
    {
        EditText editText = findViewById(R.id.birthYearEditText);
        TextView txtView = findViewById(R.id.msgtextView);

        Date date = new Date();

        String[] userBirthDate = (editText.getText().toString()).split("/");

        int year = date.getYear()+1900 - Integer.parseInt(userBirthDate[2]);
        int month = date.getMonth() - Integer.parseInt(userBirthDate[1]);
        int day = date.getDay() - Integer.parseInt(userBirthDate[0]);
        txtView.setTextSize(25);
        txtView.setText("you 're  " + year + " years, "+ month + " month" + day + " days");

        Toast.makeText(this , "Welcome to the first toast message" , Toast.LENGTH_LONG).show();
    }
}
