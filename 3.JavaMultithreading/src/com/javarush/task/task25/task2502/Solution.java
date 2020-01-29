package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            List<Wheel> list = new ArrayList<>();
            String [] wels = loadWheelNamesFromDB();
            if(wels.length!=4)
                throw new IllegalArgumentException();
            for (String str:loadWheelNamesFromDB()) {
                try{
                    list.add(Wheel.valueOf(str));
                }catch (IllegalArgumentException exp){
                    exp.printStackTrace(); }
                catch (NullPointerException e){
                    e.printStackTrace();}
            }
            this.wheels = list;
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {

        System.out.println(new Car().wheels);
    }
}
