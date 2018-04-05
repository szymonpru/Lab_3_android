package com.example.szymon_laptop.lab_3.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.szymon_laptop.lab_3.Model.Actor;
import com.example.szymon_laptop.lab_3.R;

import java.util.ArrayList;

/**
 * Created by Szymon - Laptop on 05/04/2018.
 */

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ViewHolder>
{
    private ArrayList<Actor> actors;
    private Context context;

    public ActorAdapter(Context context, ArrayList<Actor> actors)
    {
        this.context = context;
        this.actors = actors;
    }


    @Override
    public ActorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.actor_list_item, parent, false);

        return new ActorAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        final Actor actor =actors.get(position);
        holder.tvName.setText(actor.getName() + " " + actor.getSurname());
        holder.tvAge.setText(String.valueOf(actor.getAge()));
        holder.imageView.setImageResource(actor.getPhoto());
    }


    @Override
    public int getItemCount()
    {
        return actors.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView tvName, tvAge;
        public ImageView imageView;


        public ViewHolder(View view)
        {
            super(view);
            tvName = view.findViewById(R.id.tvName);
            tvAge = view.findViewById(R.id.tvAge);
            imageView = view.findViewById(R.id.imageView);

        }
    }
}