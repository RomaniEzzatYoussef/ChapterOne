package com.romani.chapterone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TeamWinActivity extends AppCompatActivity {

    Button button;

    TextView winnerTxt, teamAScore, teamBScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_win_activity);

        winnerTxt = findViewById(R.id.team_win_txtView);
        teamAScore = findViewById(R.id.teamA_txt_score);
        teamBScore = findViewById(R.id.teamB_txt_score);

        int scoreA = getIntent().getIntExtra("scoreA", 0);
        int scoreB = getIntent().getIntExtra("scoreB", 0);

        teamAScore.setText("" + scoreA);
        teamBScore.setText("" + scoreB);

        if (scoreA > scoreB)
            winnerTxt.setText("Team A is the winner");
        else if (scoreB > scoreA)
            winnerTxt.setText("Team B is the winner");
        else
            winnerTxt.setText("Team A and Team B are Draw");


        button = findViewById(R.id.showRandomNumber_button);
        button.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Toast.makeText(TeamWinActivity.this, ("number: " + (int)(Math.random() * 1000) ), Toast.LENGTH_LONG).show();
            }
        });

    }

    public void showToast(View view)
    {
        Toast.makeText(this, "Hello Toast" , Toast.LENGTH_LONG).show();
    }
}
