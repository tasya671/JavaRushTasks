package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(12));
    }

    public static boolean isPowerOfThree(int n) {
        double l = Math.log(n)/Math.log(3);
        if (l % 1 == 0.0) {
            return true;
        }
        return false;
    }
}
