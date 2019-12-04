package com.romani.chapterone;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class Session5Activity extends AppCompatActivity
{
    CalendarView picker;
    EditText birthDate;
    EditText targetDate;
    TextView diffenceDate;
    TextView days;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.session5_activity);

        birthDate = findViewById(R.id.birthDateEditText);
        targetDate = findViewById(R.id.targetDateEditText);
        diffenceDate = findViewById(R.id.different_textView);
        days = findViewById(R.id.days_textView);

        birthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

//                picker = new CalendarView(Session5Activity.this , new View.OnClickListener(){
//
//                    @Override
//                    public void onClick(View v) {
//
//                    }
//                })
            }
        });
    }

}
