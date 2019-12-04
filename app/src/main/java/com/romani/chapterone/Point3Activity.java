package com.romani.chapterone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Point3Activity extends AppCompatActivity implements View.OnClickListener {

    Button point3A_btn , point2A_btn , freeThrowA_btn ,  point3B_btn , point2B_btn , freeThrowB_btn , reset_btn;
    TextView teamAScore , teamBScore;
    int scoreA = 0;
    int scoreB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.point3_activity);

        initViews();

    }

    private void initViews()
    {
        point3A_btn = findViewById(R.id.points3A_btn);
        point2A_btn = findViewById(R.id.points2A_btn);
        freeThrowA_btn = findViewById(R.id.freeThrowA_btn);

        point3B_btn = findViewById(R.id.points3B_btn);
        point2B_btn = findViewById(R.id.points2B_btn);
        freeThrowB_btn = findViewById(R.id.freeThrowB_btn);

        reset_btn = findViewById(R.id.reset_btn);

        teamAScore = findViewById(R.id.teamAscore_txtView);
        teamBScore = findViewById(R.id.teamBscore_txtView);

        point3A_btn.setOnClickListener(this);
        point2A_btn.setOnClickListener(this);
        freeThrowA_btn.setOnClickListener(this);

        point3B_btn.setOnClickListener(this);
        point2B_btn.setOnClickListener(this);
        freeThrowB_btn.setOnClickListener(this);

        reset_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        // use switch is better for this case
        if (v.getId() == (R.id.points3A_btn))
        {
            scoreA += 3;
            displayAScore(scoreA);
        }

        if (v == findViewById(R.id.points2A_btn))
        {
            scoreA += 2;
            displayAScore(scoreA);
        }

        if (v == findViewById(R.id.freeThrowA_btn))
        {
            scoreA += 1;
            displayAScore(scoreA);
        }

        if (v == findViewById(R.id.points3B_btn))
        {
            scoreB += 3;
            displayBScore(scoreB);
        }

        if (v == findViewById(R.id.points2B_btn))
        {
            scoreB += 2;
            displayBScore(scoreB);
        }

        if (v == findViewById(R.id.freeThrowB_btn))
        {
            scoreB += 1;
            displayBScore(scoreB);
        }

        if (v == findViewById(R.id.reset_btn))
        {
            scoreA = 0;
            scoreB = 0;
            displayAScore(scoreA);
            displayBScore(scoreB);
        }


    }

    public void displayAScore(int score)
    {
        teamAScore.setText(score+"");
    }

    public void displayBScore(int score)
    {
        teamBScore.setText(score+"");
    }

    public void next(View v)
    {
        Intent i = new Intent(this , TeamWinActivity.class);
        i.putExtra("scoreA" , scoreA);
        i.putExtra("scoreB" , scoreB);
        startActivity(i);
    }
}
