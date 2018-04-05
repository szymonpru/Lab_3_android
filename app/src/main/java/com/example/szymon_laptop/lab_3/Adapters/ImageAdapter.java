package com.example.szymon_laptop.lab_3.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.szymon_laptop.lab_3.R;

import java.util.ArrayList;

/**
 * Created by Szymon - Laptop on 05/04/2018.
 */
public class ImageAdapter extends BaseAdapter
{
    private Context context;
    private ArrayList<Integer> photos;
    LayoutInflater inflater;

    public ImageAdapter(Context context, ArrayList<Integer> photos)
    {
        this.context = context;
        this.photos = photos;
    }

    @Override
    public int getCount()
    {
        return photos.size();
    }

    @Override
    public Object getItem(int i)
    {
        return photos.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup)
    {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;

        if (convertView == null)
        {
            gridView = inflater.inflate(R.layout.image_grid_item, null);
            ImageView imageView =gridView.findViewById(R.id.image);
            imageView.setImageResource(photos.get(i));
        } else
        {
            gridView = (View) convertView;
        }

        return gridView;
    }
}
