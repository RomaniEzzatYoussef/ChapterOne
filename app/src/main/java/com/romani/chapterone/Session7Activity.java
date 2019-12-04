package com.romani.chapterone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.romani.chapterone.utilities.recycleView.User;
import com.romani.chapterone.utilities.recycleView.UserViewAdapter;

public class Session7Activity extends AppCompatActivity
{

    RecyclerView myRecycleView1 , myRecycleView2;
    User[] users = new User[9];
    UserViewAdapter userViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.session7_activity);

        myRecycleView1 = findViewById(R.id.myRecycleView1);
        userViewAdapter = new UserViewAdapter(this , users);

        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        myRecycleView1.setLayoutManager(layoutManager1);
        myRecycleView1.setAdapter(userViewAdapter);

        myRecycleView2 = findViewById(R.id.myRecycleView2);
        userViewAdapter = new UserViewAdapter(this, users);

        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        myRecycleView2.setLayoutManager(layoutManager2);
        myRecycleView2.setAdapter(userViewAdapter);

        fillUserData();
    }

    public void fillUserData()
    {
        users[0] = new User();
        users[0].setUserImg(R.drawable.bella_img);
        users[0].setUser_name("Bella");
        users[0].setUserAge(16);

        users[1] = new User();
        users[1].setUserImg(R.drawable.charlie_img);
        users[1].setUser_name("Charlie");
        users[1].setUserAge(30);

        users[2] = new User();
        users[2].setUserImg(R.drawable.emma_img);
        users[2].setUser_name("Emma");
        users[2].setUserAge(55);

        users[3] = new User();
        users[3].setUserImg(R.drawable.jake_img);
        users[3].setUser_name("Jake");
        users[3].setUserAge(26);

        users[4] = new User();
        users[4].setUserImg(R.drawable.john_img);
        users[4].setUser_name("John");
        users[4].setUserAge(53);

        users[5] = new User();
        users[5].setUserImg(R.drawable.sofia_img);
        users[5].setUser_name("Sofia");
        users[5].setUserAge(44);

        users[6] = new User();
        users[6].setUserImg(R.drawable.william_img);
        users[6].setUser_name("William");
        users[6].setUserAge(33);

        users[7] = new User();
        users[7].setUserImg(R.drawable.hanna_thabet);
        users[7].setUser_name("Hanna Thabet");
        users[7].setUserAge(31);


        users[8] = new User();
        users[8].setUserImg(R.drawable.romani_user);
        users[8].setUser_name("Romani Ezzat");
        users[8].setUserAge(31);

    }

}
