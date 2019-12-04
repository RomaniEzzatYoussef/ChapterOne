package com.romani.chapterone.utilities.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.romani.chapterone.utilities.JSON.Movie;

import java.util.ArrayList;

public class MyDB extends SQLiteOpenHelper {


    public final static String DATABASE_NAME = "movies.db";
    public final static String TABLE_NAME = "movies";
    public final static String movieID = "movie_id";
    public final static String movieTitle = "movie_title";
    public final static String movieRank = "rank";
    public final static String movieOverview = "overview";
    public final static String moviePosterURL = "poster_url";

    public final static String SQL_Create_Table = "CREATE TABLE " + TABLE_NAME
            + " (" + movieID + " INTEGER primary key, " + movieTitle + " TEXT, " + movieOverview
            + " TEXT, " + moviePosterURL + " TEXT, "+ movieRank + " TEXT" + " )";

    public MyDB(Context context)
    {
        super(context, DATABASE_NAME, null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_Create_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }

    public long insertMovie(Movie movie)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(movieID , movie.getMovieID());
        contentValues.put(movieTitle , movie.getTitle());
        contentValues.put(movieOverview , movie.getOverView());
        contentValues.put(moviePosterURL , movie.getPosterPath());
        contentValues.put(movieRank , movie.getRank());

        long result = db.insert(TABLE_NAME , null , contentValues);
        db.close();
        return result;
    }

    public ArrayList<Movie> getMovies()
    {
        ArrayList<Movie> movies = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {movieID , movieTitle , movieOverview};
        Cursor cursor = db.query(TABLE_NAME, null , null, null ,null , null, null);

        cursor.moveToFirst();

        while(cursor.moveToNext())
        {
            Movie movie = new Movie();

            movie.setMovieID(cursor.getInt(0));
            movie.setTitle(cursor.getString(1));
            movie.setOverView(cursor.getString(2));
            movie.setPosterPath(cursor.getString(3));
            movie.setRank(cursor.getString(4));

            movies.add(movie);
        }

        db.close();

        return movies;
    }

    public void deleteMovies(ArrayList<Movie> movies)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i = 0; i < movies.size(); i++)
        {
            db.delete(TABLE_NAME, movieID + " = ?", new String[] {String.valueOf(movies.get(i).getMovieID())});
        }
    }
}
