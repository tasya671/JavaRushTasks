package com.javarush.task.task27.task2707;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/*
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        Method method = solution.getClass().getMethod("someMethodWithSynchronizedBlocks", Object.class, Object.class);

        synchronized (o1){

            Thread thread1 = new Thread(){
                @Override
                public void run() {
                    solution.someMethodWithSynchronizedBlocks(o1, o2);
                }
            };
            thread1.setDaemon(true);
            thread1.start();

            Thread thread2 = new Thread(){
                @Override
                public void run() {
                    synchronized (o2){
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) { }
                    }
                }
            };
            thread2.setDaemon(true);
            thread2.start();

            Thread.sleep(10);

            if(thread2.getState() != Thread.State.BLOCKED){
                return true;
            } else {
                return false;}
        }

    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
