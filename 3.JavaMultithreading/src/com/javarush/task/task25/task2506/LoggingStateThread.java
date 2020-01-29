package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;
    private State threadState;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        this.threadState = thread.getState();
    }

    @Override
    public void run() {
        System.out.println(threadState.name());
        while (true){
            State state = thread.getState();
            if(state == State.TERMINATED){
                System.out.println (state.name());
                break;
            } else if(state != threadState){
                System.out.println(state.name());
                threadState = state; }
        }
    }
}
