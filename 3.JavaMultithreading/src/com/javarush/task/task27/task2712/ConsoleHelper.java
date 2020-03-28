package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
            return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List <Dish> dishes = new ArrayList<>();
        writeMessage("Введите название блюда:");
        writeMessage(Dish.allDishesToString());

        String order;
        while (!(order=readString()).equalsIgnoreCase("exit")){
            try{
                Dish dish = Dish.valueOf(order);
                dishes.add(dish);
            }
            catch (IllegalArgumentException exp){
                writeMessage("Такого блюда в меню не представлено.");
            }
            writeMessage("Введите название следующего блюда или exit для заверешения заказа:");
        }
        return dishes;
    }
}
