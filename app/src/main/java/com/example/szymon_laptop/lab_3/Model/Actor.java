package com.example.szymon_laptop.lab_3.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Szymon - Laptop on 05/04/2018.
 */

public class Actor implements Parcelable {

    private String name, surname;
    private int age, photo;

    public Actor(String name, String surname, int age, int photo)
    {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.photo = photo;
    }

    protected Actor(Parcel in)
    {
        name = in.readString();
        surname = in.readString();
        age = in.readInt();
        photo = in.readInt();
    }

    public static final Creator<Actor> CREATOR = new Creator<Actor>()
    {
        @Override
        public Actor createFromParcel(Parcel in)
        {
            return new Actor(in);
        }

        @Override
        public Actor[] newArray(int size)
        {
            return new Actor[size];
        }
    };


    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(name);
        parcel.writeString(surname);
        parcel.writeInt(age);
        parcel.writeInt(photo);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getPhoto()
    {
        return photo;
    }

}