package com.romani.chapterone;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Session8_1Activity extends AppCompatActivity
{

    private final String URL_l = "https://api.themoviedb.org/3/movie/550?api_key=87b064227e93f958c60b2dd2f4300186";
    String myTXT = "\n\n";

    TextView myURLTXT;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.session8_1_activity);

        progressBar = findViewById(R.id.myProgress);
        myURLTXT = findViewById(R.id.myURLTXT);

        NetWorkExample netWorkExample = new NetWorkExample();
        netWorkExample.execute();
    }

    class NetWorkExample extends AsyncTask<Void, Void, String>
    {

        String responseData = null;

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
                url = new URL(URL_l);
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

                myTXT = "\n\n" +  stringBuilder.toString();

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
            myURLTXT.setText(myTXT);
        }
    }
}
