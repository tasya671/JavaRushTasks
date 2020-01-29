package com.javarush.task.task27.task2710;

public class Mail {
    private String text;

    public synchronized String getText() {
        while (text == null) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return text;
    }

    public synchronized void setText(String text) {
        this.text = text;
        this.notifyAll();
    }
}
