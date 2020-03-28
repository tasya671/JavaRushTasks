package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {

    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue;

    public Cook(String name) {
        this.name = name;
    }


    public void startCookingOrder(Order order){
        try
        {
            this.busy = true;
            StatisticManager.getInstance()
                .register(new CookedOrderEventDataRow(order.getDishes().toString(),
                        name, order.getTotalCookingTime()*60, order.getDishes()));
            ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time "+order.getTotalCookingTime() +"min");
            Thread.sleep(10*order.getTotalCookingTime());
            setChanged();
            notifyObservers(order);
            this.busy = false;
        }
        catch (InterruptedException exp){}
    }

    public boolean isBusy() {
        return busy;

    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        try{
        while (true) {
            while (!queue.isEmpty()){
                Order order = queue.take();
                startCookingOrder(order);
            }
            Thread.sleep(10);
        }
        }catch (InterruptedException exp) {}
    }
}
