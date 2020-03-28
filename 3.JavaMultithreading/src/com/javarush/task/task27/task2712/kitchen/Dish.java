package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString(){
       return Arrays.toString(Dish.values());
    }

    public int getDuration() {
        return duration;
    }


    private int duration;


}
