package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        try{
            String number = args[0].toUpperCase();
            if (number.matches("[0-9A-Z]++")) {
                for (int i = 2; i <= 36; i++) {
                    try {
                        new BigInteger(args[0].toLowerCase(), i);
                        System.out.println(i);
                        break;
                    } catch (Exception exp) {}
                }
            } else
                System.out.println("incorrect");
        }catch (Exception e){}
    }
}