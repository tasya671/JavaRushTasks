package com.javarush.task.task25.task2504;

import java.util.Arrays;
import java.util.List;

/*
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        if (threads.length == 0 || threads == null) return;
        List<Thread> threads1 = Arrays.asList(threads);
        for (Thread thread:threads1) {
            Thread.State state = thread.getState();
            switch (state){

                case NEW:
                    thread.start();
                    break;
                case WAITING:
                    thread.interrupt();
                    break;
                case TIMED_WAITING:
                    thread.interrupt();
                    break;
                case BLOCKED:
                    thread.interrupt();
                    break;
                case RUNNABLE:
                    thread.isInterrupted();
                    break;
                case TERMINATED:
                    System.out.println(thread.getPriority());
                    break;
            }
        }
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {
    }
}
