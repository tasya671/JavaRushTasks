package com.javarush.task.task34.task3403;

import java.util.ArrayList;
import java.util.List;

/*
Разложение на множители с помощью рекурсии
*/
public class Solution {

    public void recurse(int n) {
        if (n > 1) {
            List<Integer> simpleNumeric = simpleNumeric(n);

            for (int i = 0; i < simpleNumeric.size(); i++) {
                int a = n / simpleNumeric.get(i);
                int r = n % simpleNumeric.get(i);
                if (r == 0) {
                    System.out.printf(simpleNumeric.get(i) + " ");
                    recurse(a);
                    break;
                } else if (a == 1 && r == 0) {
                    System.out.printf(simpleNumeric.get(i).toString());
                    break;
                }
            }
        }
    }

    private List<Integer> simpleNumeric(int n){
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <=i ; j++) {
                if(i % j == 0 & i!=j)
                    break;
                if(i == j)
                    result.add(i);
            }
        }
        return result;
    }
}
