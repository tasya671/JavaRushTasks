package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {

       List<String> list = Arrays.asList(s.split(""));
       int result = 0;
       int previous = 0;
        for (int i = list.size()-1; i >=0 ; i--) {
            int current = map.get(list.get(i));
            if(current >= previous){
                result+=current;
            } else {
                result-=current;
            }
            previous = current;
        }
        return result;
    }

    private static Map<String, Integer> map = new HashMap<>();
    static {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
    }

}
