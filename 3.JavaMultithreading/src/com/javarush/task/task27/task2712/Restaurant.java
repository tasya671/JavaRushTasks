package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private final static int ORDER_CREATING_INTERVAL = 100;
    private final static LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();


    public static void main(String[] args) {

        for (int i = 1; i<= 2; i++) {
            Cook cook = new Cook("KirillSleeping "+i);
            cook.setQueue(orderQueue);
            Thread thread = new Thread(cook);
            thread.setDaemon(true);
            thread.start();
        }

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 1; i <= 5 ; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
            tablets.add(tablet);
        }

        Waiter waiter = new Waiter();

        DirectorTablet directorTablet = new DirectorTablet();

        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException exp){}

        thread.interrupt();

        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();

    }
}
