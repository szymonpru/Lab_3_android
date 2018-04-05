package com.example.szymon_laptop.lab_3.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.szymon_laptop.lab_3.Adapters.ImageAdapter;
import com.example.szymon_laptop.lab_3.R;

import java.util.ArrayList;

public class Images extends Fragment
{
    private GridView gridView;
    private ArrayList<Integer> images;
    private View view;
    private final static String EXTRA_IMAGES = "com.example.psliw.movies.IMAGES";



    public static Images newInstance(ArrayList<Integer> images)
    {
        Images fragment = new Images();
        Bundle args = new Bundle();

        args.putIntegerArrayList(EXTRA_IMAGES, images);
        fragment.setArguments(args);

        return(fragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.activity_images,container,false);
        images = getArguments().getIntegerArrayList(EXTRA_IMAGES);
        gridView = view.findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(view.getContext(), images));
        return view;
    }
}