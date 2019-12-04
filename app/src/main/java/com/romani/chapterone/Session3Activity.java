package com.romani.chapterone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Session3Activity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    TextView txtView;
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.session3_activity);

        editText = findViewById(R.id.birthEditText);
        txtView = findViewById(R.id.datecalucationTextView);
        btn = findViewById(R.id.startBtn);

        btn.setOnClickListener(this);


    }

    public void calculateAge(View v) {

        String userBirthDate = editText.getText().toString();
        int age =  2019 - Integer.parseInt(userBirthDate);

        txtView.setTextSize(25);
        txtView.setText("you 're  " + age + " year");
    }

    @Override
    public void onClick(View v) {

        String userBirthDate = editText.getText().toString();
        int age =  2019 - Integer.parseInt(userBirthDate);

        txtView.setTextSize(25);
        txtView.setText("you 're  " + age + " year");
    }
}
