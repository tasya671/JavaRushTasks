package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> list = new HashMap<>();
        while (true) {
            String city = reader.readLine();
            if (city.isEmpty()) {
                break;
            }
            String family = reader.readLine();
            list.put(city, family);
        }

        // Read the house number
        String cityres = reader.readLine();
        reader.close();


        Set<String> set = list.keySet();
        for (String s: set) {
            if(s.equalsIgnoreCase(cityres)){
                System.out.println(list.get(s));
            }
        }

    }
}
