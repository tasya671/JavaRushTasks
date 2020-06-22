package com.javarush.task.task30.task3009;

/* 
Палиндром?
*/

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number){
        Set<Integer> set = new HashSet<>();
        String oneTile;
        String twoTile;
        try {
            for (int i = 2; i <= 36; i++) {
                BigInteger bigInteger = new BigInteger(number);
                String str = bigInteger.toString(i);
                if (str.length() % 2 == 0) {
                    int mid = str.length() / 2;
                    oneTile = str.substring(0, mid);
                    twoTile = new StringBuilder(str.substring(mid)).reverse().toString();
                } else {
                    int mid = str.length() / 2;
                    oneTile = str.substring(0, mid);
                    twoTile = new StringBuilder(str.substring(mid + 1)).reverse().toString();
                }
                if (oneTile.equals(twoTile)) {
                    set.add(i);
                }
            }
        } catch (NumberFormatException exp){}
        return set;
    }
}