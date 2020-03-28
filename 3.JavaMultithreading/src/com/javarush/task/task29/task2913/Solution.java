package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder builder = new StringBuilder();
        int max;
        int add;
            if(a<b){
                max = b+1;
                add = 1;
            } else{
                max = b-1;
                add= -1;
            }
            for (int i = a; i !=max; i=i+add) {
                if(i!=b){
                    builder.append(i+" ");
                }
                else
                    builder.append(i);
            }
        return builder.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}