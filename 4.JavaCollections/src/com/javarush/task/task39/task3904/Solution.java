package com.javarush.task.task39.task3904;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Лестница
*/
public class Solution {
    private static int n = 70;
    private static final Map<Integer, Long> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public synchronized static long numberOfPossibleAscents(int n) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        long pr1 = 1;
        long pr2 = 1;
        long pr3 = 2;
        long var = 0;
        for (int i = 3; i <= n ; i++) {
            var = pr1 + pr2 + pr3;
            pr1 = pr2;
            pr2 = pr3;
            pr3 = var;
        }
        return var;
    }
}

