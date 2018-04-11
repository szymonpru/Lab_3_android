package com.example.szymon_laptop.lab_3.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.szymon_laptop.lab_3.Adapters.ActorAdapter;
import com.example.szymon_laptop.lab_3.Model.Actor;
import com.example.szymon_laptop.lab_3.R;

import java.util.ArrayList;

public class Actors extends Fragment
{

    private  View view;
    private ArrayList<Actor> actors;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private final static String EXTRA_ACTORS= "com.example.szymon_pruszek.lab_3.ACTORS";

    public static Actors newInstance(ArrayList<Actor> actors)
    {
        Actors fragment = new Actors();
        Bundle args = new Bundle();

        args.putParcelableArrayList(EXTRA_ACTORS, actors);
        fragment.setArguments(args);

        return(fragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)

    {
        view = inflater.inflate(R.layout.activity_actors, container, false);
        actors = getArguments().getParcelableArrayList(EXTRA_ACTORS);

        setRecyclerView();
        return view;
    }

    private void setRecyclerView()
    {
        recyclerView = view.findViewById(R.id.actors_recycle_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        adapter = new ActorAdapter(getContext(), actors);
        recyclerView.setAdapter(adapter);
    }


}