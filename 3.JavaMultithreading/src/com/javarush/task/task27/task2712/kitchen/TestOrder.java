package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestOrder extends Order {


    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        Random random = new Random();
        List<Dish> dishList = new ArrayList<>();
        Dish [] dishes = Dish.values();
        int countDishes = random.nextInt(7);
        for (int i = 0; i < countDishes ; i++) {
            dishList.add(dishes[random.nextInt(dishes.length)]);
        }
        this.dishes = dishList;
    }
}
