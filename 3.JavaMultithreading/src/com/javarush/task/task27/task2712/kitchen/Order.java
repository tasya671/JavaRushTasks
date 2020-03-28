package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;


    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    protected void initDishes() throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime(){
        int timeCooking =0;
        for (Dish dish: dishes) {
            timeCooking+=dish.getDuration();
        }
        return timeCooking;
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    public Tablet getTablet() {
        return tablet;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void createTestOrder(){

    }

    @Override
    public String toString() {
        return dishes.isEmpty()? "": "Your order: "+ dishes + " of " + tablet;
    }
}
