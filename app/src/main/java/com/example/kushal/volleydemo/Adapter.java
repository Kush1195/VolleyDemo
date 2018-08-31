package com.example.kushal.volleydemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder>
{

    private Context context;
    private User[] users;

    public Adapter(Context context, User[] users)
    {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.adapter,viewGroup,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i)
    {
        User user = users[i];
        holder.textView.setText(user.getLogin());
        Picasso.with(holder.imageView.getContext()).load(user.getAvatar_url()).resize(600,600).into(holder.imageView);
    }

    @Override
    public int getItemCount()
    {
        return users.length;
    }

    public class Holder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;
        public Holder(View itemView)
        {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.i);
            textView=(TextView)itemView.findViewById(R.id.t1);

        }
    }
}
