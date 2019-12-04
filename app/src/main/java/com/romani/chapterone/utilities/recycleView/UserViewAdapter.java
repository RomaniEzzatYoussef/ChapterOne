package com.romani.chapterone.utilities.recycleView;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.romani.chapterone.R;
import com.romani.chapterone.UsersDetailsActivity;

public class UserViewAdapter extends RecyclerView.Adapter<UserViewAdapter.UserViewHolder>
{
    User[] users;

    Context context;
    public UserViewAdapter(Context context, User[] users)
    {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View userView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view1, viewGroup, false);
        UserViewHolder userViewHolder = new UserViewHolder(userView);
        return userViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i)
    {
        User user = users[i];
        userViewHolder.imageView.setImageResource(users[i].getUserImg());
        userViewHolder.userName.setText(users[i].getUser_name());
        userViewHolder.userAge.setText(users[i].getUserAge() + "");

        userViewHolder.userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context , UsersDetailsActivity.class);
                 context.startActivity(i);

            }
        });

    }


    @Override
    public int getItemCount() {
        return users.length;
    }

    class UserViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView, imageView1;
        TextView userName , userAge;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.myImageView1);
            userName = itemView.findViewById(R.id.myUserName);
            userAge = itemView.findViewById(R.id.myUserAge);
        }
    }
}
