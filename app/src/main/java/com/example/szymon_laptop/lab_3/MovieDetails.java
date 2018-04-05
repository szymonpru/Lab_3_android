package com.example.szymon_laptop.lab_3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.szymon_laptop.lab_3.Adapters.PageTransformer;
import com.example.szymon_laptop.lab_3.Fragments.Actors;
import com.example.szymon_laptop.lab_3.Fragments.Images;
import com.example.szymon_laptop.lab_3.Model.Movie;

public class MovieDetails extends AppCompatActivity {

    private TextView tvTitle, tvCategory, tvRating;
    private ImageView imageView;
    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private PagerAdapter pagerAdapter;
    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        setLayoutView();
        setViewPager();
    }

    private void setViewPager()
    {
        viewPager =findViewById(R.id.viewPager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(true, new PageTransformer());
    }


    private void setLayoutView()
    {
        tvTitle = findViewById(R.id.tvTitle);
        tvCategory = findViewById(R.id.tvCategory);
        tvRating=findViewById(R.id.tvRating);
        imageView = findViewById(R.id.imageView);
        linearLayout=findViewById(R.id.linearLayout);

        Bundle data = getIntent().getExtras();
        movie = data.getParcelable("movie");

        tvTitle.setText(movie.getTitle());
        tvCategory.setText(movie.getCategory());
        tvRating.setText(String.valueOf(movie.getRating()));
        imageView.setImageResource(movie.getImg());

    }


    private class ScreenSlidePagerAdapter extends FragmentPagerAdapter
    {

        private static final int NUM_PAGES = 2;


        public ScreenSlidePagerAdapter(FragmentManager fragmentManager)

        {
            super(fragmentManager);

        }

        @Override
        public Fragment getItem(int position)
        {
            switch(position)
            {
                case 0:
                    return Images.newInstance(movie.getPhotos());
                case 1:
                    return Actors.newInstance(movie.getActors());

                default:
                    return Images.newInstance(movie.getPhotos());
            }
        }

        @Override
        public int getCount()
        {
            return NUM_PAGES;
        }
    }
}
