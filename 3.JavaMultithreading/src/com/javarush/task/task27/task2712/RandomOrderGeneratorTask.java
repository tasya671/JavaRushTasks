package com.javarush.task.task27.task2712;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {

    private List<Tablet> tablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        if(tablets.isEmpty())
            return;
            try {
                while (!Thread.currentThread().isInterrupted()){
                Thread.sleep(interval);
                int numberTablet = (int) Math.random()*tablets.size();
                tablets.get(numberTablet).createTestOrder();
                }
            }catch (InterruptedException e) { }

    }

}

