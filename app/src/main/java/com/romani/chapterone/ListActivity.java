package com.romani.chapterone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    ListView listView1, listView2;
    String[] names = new String[100];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        listView1 = findViewById(R.id.list_view);
        listView2 = findViewById(R.id.list2_view);

        intiArray();
        //ArrayAdapter listAdapter = new ArrayAdapter(this, R.layout.item_list, names);


        //listView1.setAdapter(listAdapter);
        //listView2.setAdapter(listAdapter);
    }

    private void intiArray()
    {
        int o = 23456789;
        for (int i = 0; i < names.length; i++)
            names[i] = "012" + o++;
    }
}
