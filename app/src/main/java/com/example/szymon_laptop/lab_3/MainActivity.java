package com.example.szymon_laptop.lab_3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.szymon_laptop.lab_3.Adapters.MovieAdapter;
import com.example.szymon_laptop.lab_3.Model.Actor;
import com.example.szymon_laptop.lab_3.Model.Category;
import com.example.szymon_laptop.lab_3.Model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;

    private List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieList=new ArrayList<>();

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadExampleData();
        movieAdapter=new MovieAdapter(this,movieList);
        recyclerView.setAdapter(movieAdapter);

    }

    private void loadExampleData(){
        ArrayList<Integer> images= new ArrayList<>();
        ArrayList<Actor> actors= new ArrayList<>();
        images.add(R.drawable.forrest_gump);
        images.add(R.drawable.gladiator);
        images.add(R.drawable.forrest_gump);
        images.add(R.drawable.gladiator);
        images.add(R.drawable.forrest_gump);
        images.add(R.drawable.gladiator);
        actors.add(new Actor("Marlon","Brando", 60,R.drawable.jaws));
        actors.add(new Actor("Al","Pacino", 60,R.drawable.jaws));
        actors.add(new Actor("James","Cann", 70,R.drawable.jaws));
        actors.add(new Actor("Richard S.","Castellano", 40,R.drawable.jaws));
        actors.add(new Actor("Robert","Duvall", 30,R.drawable.jaws));
        actors.add(new Actor("Sterling","Hayden", 46,R.drawable.jaws));
        actors.add(new Actor("John","Marley", 68,R.drawable.jaws));

        movieList.add(new Movie(1,"The Godfather",R.drawable.godfather,String.valueOf(Category.Crime),9.2, images,actors));
        movieList.add(new Movie(2,"Forrest Gump",R.drawable.forrest_gump,String.valueOf(Category.Drama),8.8, new ArrayList<Integer>(), new ArrayList<Actor>()));
        movieList.add(new Movie(3,"The Lord of the Rings: The Return of the King",R.drawable.lord_of_the_rings,String.valueOf(Category.Adventure),8.9, new ArrayList<Integer>(), new ArrayList<Actor>()));
        movieList.add(new Movie(4,"Gladiator",R.drawable.gladiator,String.valueOf(Category.Drama),8.5, new ArrayList<Integer>(), new ArrayList<Actor>()));
        movieList.add(new Movie(5,"Rocky",R.drawable.rocky,String.valueOf(Category.Sport),8.1, new ArrayList<Integer>(), new ArrayList<Actor>()));
        movieList.add(new Movie(6,"Jaws",R.drawable.jaws,String.valueOf(Category.Horror),8.0, new ArrayList<Integer>(), new ArrayList<Actor>()));
    }

}
