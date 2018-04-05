package com.example.szymon_laptop.lab_3.Model;

/**
 * Created by Szymon - Laptop on 04/04/2018.
 */

public enum Category {
    Drama("RED"),
    Sport("PURPLE"),
    Horror("RED"),
    Crime("BLACK"),
    Adventure("GREEN");

    private final String color;

    Category(String color){
        this.color=color;
    }

    public String getColor() {
        return color;
    }
}

