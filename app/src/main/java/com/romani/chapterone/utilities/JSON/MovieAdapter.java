package com.romani.chapterone.utilities.JSON;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.romani.chapterone.MovieActivity;
import com.romani.chapterone.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter  extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>
{
    ArrayList<Movie> moviesList = new ArrayList<>();

    Context context;
    public MovieAdapter(Context context, ArrayList<Movie> moviesList)
    {
        this.context = context;
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View moView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_item, viewGroup, false);
        MovieAdapter.MovieViewHolder movieViewHolder = new MovieAdapter.MovieViewHolder(moView);
        return movieViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder movieViewHolder, int i)
    {
        Movie movie = moviesList.get(i);

        Picasso.get().load("https://image.tmdb.org/t/p/w500" + movie.getPosterPath()).into(movieViewHolder.moviePoster);
        movieViewHolder.title.setText(movie.getTitle());
        movieViewHolder.rank.setText(movie.getRank());


    }


    @Override
    public int getItemCount() {
        return moviesList.size();
    }


    class MovieViewHolder extends RecyclerView.ViewHolder
    {
        ImageView moviePoster;
        TextView title , rank;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            moviePoster = itemView.findViewById(R.id.MoviePoster);
            title = itemView.findViewById(R.id.movieTitle);
            rank = itemView.findViewById(R.id.movieRank);

            moviePoster.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Movie movie = moviesList.get(getAdapterPosition());
                    Intent i = new Intent(context , MovieActivity.class);
                    i.putExtra("moviePoster" , "https://image.tmdb.org/t/p/w500" + movie.getPosterPath());
                    i.putExtra("title" , movie.getTitle());
                    i.putExtra("rank" , movie.getRank());
                    i.putExtra("overview", movie.getOverView());
                    context.startActivity(i);
                }
            });
        }
    }
}
