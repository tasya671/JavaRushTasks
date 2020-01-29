package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws  IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        reader.close();
        String [] array = url.split("\\?");
        Map<String, String > map = new LinkedHashMap();
        String [] param = array[1].split("&");
        for (String par : param) {
            String [] result = par.split("=");
            if(result.length ==2)
                map.put(result[0], result[1]);
            else
                map.put(result[0], "0");
        }
        Set<String> set = map.keySet();
        for (String str : set) {
            System.out.print(str+" "); }

        System.out.println();

        if (set.contains("obj")) {
            String value = map.get("obj");
            try{
                Integer integer = Integer.parseInt(value);
                alert(integer);
            }catch (NumberFormatException e) {
                try {
                    alert(Double.parseDouble(value));
                } catch (NumberFormatException exp) {
                    alert(value);
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
