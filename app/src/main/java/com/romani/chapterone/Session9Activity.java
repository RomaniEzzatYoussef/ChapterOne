package com.romani.chapterone;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import com.romani.chapterone.utilities.JSON.Movie;
import com.romani.chapterone.utilities.JSON.MovieAdapter;
import com.romani.chapterone.utilities.db.MyDB;
import com.romani.chapterone.utilities.recycleView.User;
import com.romani.chapterone.utilities.recycleView.UserViewAdapter;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.romani.chapterone.utilities.JSON.Movie;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Session9Activity extends AppCompatActivity implements View.OnClickListener
{
    public ArrayList<Movie> movies = new ArrayList<>();

    private final String URL_KEY = "87b064227e93f958c60b2dd2f4300186";
    private final String URL_l = "https://api.themoviedb.org/3/movie";


    private SharedPreferences sharedPreferences;

    Uri  moviesUri = Uri.parse(URL_l).buildUpon().appendPath("popular").appendQueryParameter("api_key" , URL_KEY).build();
    ProgressBar progressBar;
    RecyclerView movieRecycleView;
    RadioButton popularRB , topRatedRB;

    MyDB myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.session9_activity);

        movieRecycleView = findViewById(R.id.movieRecyclerView);
        popularRB = findViewById(R.id.popular_rb);
        topRatedRB = findViewById(R.id.topRated_rb);

        popularRB.setOnClickListener(this);
        topRatedRB.setOnClickListener(this);

        myDB = new MyDB(this);
        movies = myDB.getMovies();
        bindRecycler();

        progressBar = findViewById(R.id.myProgressMovie);

        sharedPreferences = getPreferences(MODE_PRIVATE);

        String sort_perfs = sharedPreferences.getString("sort_perfs" , "");
        if(sort_perfs.equals("Top Rated") )
            topRatedRB.setChecked(true);



    }

    @Override
    protected void onRestart() {
        super.onRestart();
        NetWorkExample netWorkExample = new NetWorkExample();
        netWorkExample.execute();
    }

    @Override
    public void onClick(View v)
    {
        if (v.getId() == R.id.popular_rb)
        {
            popularRB.setEnabled(false);
            topRatedRB.setEnabled(true);
            moviesUri = Uri.parse(URL_l).buildUpon().appendPath("popular").appendQueryParameter("api_key" , URL_KEY).build();

            sharedPreferences.edit().putString("sort_perfs" , "popular").commit();

            NetWorkExample netWorkExample = new NetWorkExample();
            netWorkExample.execute();
        }

        if (v.getId() == R.id.topRated_rb)
        {
            popularRB.setEnabled(true);
            topRatedRB.setEnabled(false);
            moviesUri = Uri.parse(URL_l).buildUpon().appendPath("top_rated").appendQueryParameter("api_key" , URL_KEY).build();

            sharedPreferences.edit().putString("sort_perfs" , "Top Rated").commit();

            NetWorkExample netWorkExample = new NetWorkExample();
            netWorkExample.execute();
        }
    }

    class NetWorkExample extends AsyncTask<Void, Void, String>
    {

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);

        }

        @Override
        protected String doInBackground(Void... voids)
        {
            StringBuilder stringBuilder = null;
            URL url = null;


            try
            {
                url = new URL(moviesUri.toString());
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }



            try
            {
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                stringBuilder = new StringBuilder();

                String line = null;

                while ((line = bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(line).append("\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return stringBuilder.toString();
        }

        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            progressBar.setVisibility(View.GONE);
            parseJSON(s);

            myDB.deleteMovies(movies);

            for (Movie movie : movies)
            {
                myDB.insertMovie(movie);
            }

           bindRecycler();

        }
    }

    public void bindRecycler()
    {
        MovieAdapter movieAdapter = new MovieAdapter(Session9Activity.this , movies);
        movieRecycleView.setAdapter(movieAdapter);

        RecyclerView.LayoutManager layoutManager1 = new GridLayoutManager(Session9Activity.this, 2);
        movieRecycleView.setLayoutManager(layoutManager1);
    }

    public void parseJSON(String response)
    {
        if (response == null)
            return;

        movies.clear();
        try
        {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            for (int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject movieObj = jsonArray.getJSONObject(i);

                Movie movie = new Movie();

                movie.setMovieID(movieObj.getInt("id"));
                movie.setTitle(movieObj.getString("title"));
                movie.setRank(movieObj.getString("vote_average"));
                movie.setPosterPath(movieObj.getString("poster_path"));
                movie.setOverView(movieObj.getString("overview"));




                movies.add(movie);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
