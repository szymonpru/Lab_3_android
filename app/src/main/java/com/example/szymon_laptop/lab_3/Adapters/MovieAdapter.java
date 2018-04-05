package com.example.szymon_laptop.lab_3.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.szymon_laptop.lab_3.Model.Movie;
import com.example.szymon_laptop.lab_3.MovieDetails;
import com.example.szymon_laptop.lab_3.R;

import java.util.List;

/**
 * Created by Szymon - Laptop on 04/04/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private List<Movie> movieList;

    public MovieAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.movie_list_item, null);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        final Movie movie=movieList.get(position);

        holder.textViewTitle.setText(movie.getTitle());
        holder.textViewCategory.setText(movie.getCategory());
        holder.textViewRating.setText(String.valueOf(movie.getRating()));
        holder.imageView.setImageDrawable(context.getResources().getDrawable(movie.getImg()));

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context,MovieDetails.class);
                intent.putExtra("movie", movie);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textViewTitle;
        TextView textViewCategory;
        TextView textViewRating;
        LinearLayout linearLayout;

        public MovieViewHolder(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            textViewTitle=itemView.findViewById(R.id.textViewTitle);
            textViewCategory=itemView.findViewById(R.id.textViewCategory);
            textViewRating=itemView.findViewById(R.id.textViewRating);
            linearLayout=itemView.findViewById(R.id.linearLayout);
        }
    }
}
