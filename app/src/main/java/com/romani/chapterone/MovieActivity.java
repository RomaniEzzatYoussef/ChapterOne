package com.romani.chapterone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieActivity extends AppCompatActivity {

    ImageView moviePosterV;
    TextView titleV , rankV , overviewV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_activity);

        moviePosterV = findViewById(R.id.myMoviePoster);
        titleV = findViewById(R.id.myMovieTitle);
        rankV = findViewById(R.id.myMovieRank);
        overviewV = findViewById(R.id.overview);

        String moviePoster = getIntent().getStringExtra("moviePoster");
        String title = getIntent().getStringExtra("title");
        String rank = getIntent().getStringExtra("rank");
        String overview = getIntent().getStringExtra("overview");


        Picasso.get().load(moviePoster).into(moviePosterV);
        titleV.setText(title);
        rankV.setText(rank);
        overviewV.setText(overview);

    }
}
