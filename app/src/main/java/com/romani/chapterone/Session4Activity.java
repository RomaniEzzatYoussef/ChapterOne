package com.romani.chapterone;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Session4Activity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    EditText editText;
    TextView txtView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.session4_activity);

        editText = findViewById(R.id.birthEditText2);
        txtView = findViewById(R.id.datecalucationTextView2);
        btn = findViewById(R.id.startBtn2);
        txtView.setOnClickListener(this);
        btn.setOnClickListener(this);
        editText.addTextChangedListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.startBtn2)
        {
            onClickBirth();
        }

        else if (v.getId() == R.id.birthEditText2)
        {
            onClickBirth();
        }

        else if (v.getId() == R.id.datecalucationTextView2)
        {
            onClickBirth();
        }

        else
        {
            Toast.makeText(this , "Is Absoultly Clicked" , Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        onClickBirth();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    public void onClickBirth()
    {

        try
        {
            String userBirthDate = editText.getText().toString();
            int userBD = Integer.parseInt(userBirthDate);

            if (userBD < 2019)
            {
                int age =  2019 - userBD;

                txtView.setTextColor(Color.BLACK);
                txtView.setTextSize(25);
                txtView.setText("you 're  " + age + " year");
            }
            else
            {
                txtView.setTextSize(20);
                txtView.setTextColor(Color.RED);
                txtView.setText(" Input greater of current year 2019");
            }
        }

        catch (Exception ex)
        {
            txtView.setTextSize(18);
            txtView.setTextColor(Color.RED);
            txtView.setText(ex.toString());
        }


        Log.e("MyTag",txtView.getText().toString());

    }





    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Activity Recycle", "OnStart");
        Toast.makeText(this, "OnStart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Activity Recycle", "onResume");
        Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Activity Recycle", "onRestart");
        Toast.makeText(this, "onRestart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Activity Recycle", "onPause");
        Toast.makeText(this, "onPause", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Activity Recycle", "onStop");
        Toast.makeText(this, "onStop", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Activity Recycle", "onDestroy");
        Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Return To Amit Session Activity", Toast.LENGTH_LONG).show();
        Log.e("MyTag","Return To Amit Session Activity");
        startActivity(new Intent("com.romani.chapterone.AmitSessionsActivity"));

    }


    // "Send text back" button click
    public void onButtonClick(View view) {

        // Get the text from the EditText
        TextView myText =  findViewById(R.id.datecalucationTextView2);
        String stringToPassBack = myText.getText().toString();

        // Put the String to pass back into an Intent and close this activity
        Intent intent = new Intent();
        intent.putExtra("keyName", stringToPassBack);
        setResult(RESULT_OK, intent);
        finish();
    }

}