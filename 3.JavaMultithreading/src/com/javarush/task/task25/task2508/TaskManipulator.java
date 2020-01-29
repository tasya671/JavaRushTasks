package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {

    private Thread thread;

    public TaskManipulator() {
    }

    @Override
    public void run() {

        while (!thread.isInterrupted()){
            try {
                Thread.sleep(0);
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);

            } catch (InterruptedException e) {
               // e.printStackTrace();
                break;
            }
        }
    }

    @Override
    public void start(String threadName) {
        thread = new Thread(this);
        thread.setName(threadName);
        thread.start();

    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
