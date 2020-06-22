package com.javarush.task.task30.task3004;


import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {

    private int x;


    public BinaryRepresentationTask(int i) {
        this.x = i;
    }

    @Override
    protected String compute() {
        String result;
        int b = x/2;
        result = String.valueOf(this.x%2);
        if (b > 0){
            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
            task.fork();
            result = task.join() + result;
        }return result;
    }
}