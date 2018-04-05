package com.example.szymon_laptop.lab_3.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Szymon - Laptop on 04/04/2018.
 */

public class Movie implements Parcelable{

    private int id;
    private String title;
    private int img;
    private String category;
    private double rating;
    private ArrayList<Integer> photos;
    private ArrayList<Actor> actors;

    public Movie(int id, String title, int img, String category, double rating, ArrayList<Integer> photos, ArrayList<Actor> actors) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.category = category;
        this.rating=rating;
        this.photos=photos;
        this.actors=actors;
    }

    protected Movie(Parcel in)
    {
        title = in.readString();
        category = in.readString();
        rating=in.readDouble();
        img = in.readInt();
        photos = (ArrayList<Integer>) in.readSerializable();
        actors = in.createTypedArrayList(Actor.CREATOR);
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(title);
        parcel.writeString(category);
        parcel.writeDouble(rating);
        parcel.writeInt(img);
        parcel.writeSerializable(photos);
        parcel.writeTypedList(actors);
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>()
    {
        @Override
        public Movie createFromParcel(Parcel in)
        {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size)
        {
            return new Movie[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ArrayList<Integer> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<Integer> photos) {
        this.photos = photos;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }
}
