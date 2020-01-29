package com.javarush.task.task25.task2511;

import java.io.IOException;
import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String name = t.getName().replaceAll(".","*");
                String message = e.getMessage().replace(t.getName(),name);
                t.setName(name);
                e = new Exception(message, e.getCause());
                System.out.println(e.getMessage());
            }
        };    //init handler here
    }

    public void run() {
        try {
            original.run();
            throw new IOException();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        new Solution(new TimerTask() {
            @Override
            public void run() {

            }
        }).run();
    }
}