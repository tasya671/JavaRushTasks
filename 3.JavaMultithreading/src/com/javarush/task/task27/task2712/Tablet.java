package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {

    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;
    private Order current;

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder(){

        Order order = null;
        try {
            order = new Order(this);
            registerOrder(order);
            return order;
        } catch (
                NoVideoAvailableException e)
        {
            logger.log(Level.INFO, "No video is available for the order " + order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        return null;
    }


    public void createTestOrder(){
        TestOrder order = null;
        try {
            order = new TestOrder(this);
            registerOrder(order);
        } catch (
                NoVideoAvailableException e)
        {
            logger.log(Level.INFO, "No video is available for the order " + order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    private void registerOrder(Order order) {
        if (!order.isEmpty()) {
           try {
               ConsoleHelper.writeMessage(order.toString());
               new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
               queue.put(order);
           } catch (InterruptedException exp){ConsoleHelper.writeMessage("Error create order");}
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
