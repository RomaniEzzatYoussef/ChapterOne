package com.romani.chapterone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import com.romani.chapterone.utilities.db.MyDB;

public class Session6Activity extends AppCompatActivity
{

    EditText name , lastName , email, mobile, address, birthDate, age, password;
    RadioButton male, female;
    Button register;
    CheckBox termsAndConditions;

    MyDB myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.session6_activity);

        myDB = new MyDB(this);

    }

    private void initViews()
    {
        name = findViewById(R.id.name_editText);
        lastName = findViewById(R.id.last_name_editText);
        name = findViewById(R.id.name_editText);
        name = findViewById(R.id.name_editText);
        name = findViewById(R.id.name_editText);
        name = findViewById(R.id.name_editText);
        name = findViewById(R.id.name_editText);
        name = findViewById(R.id.name_editText);
    }

    public void listView(View v)
    {
        Intent i = new Intent(this, ListActivity.class);
        startActivity(i);
    }

}
