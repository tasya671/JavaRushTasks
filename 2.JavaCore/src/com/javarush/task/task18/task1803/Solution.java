package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName);
        Map<Integer, Integer> map = new LinkedHashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int number;
        int freq =1;

        while (inputStream.available() > 0){
            number = inputStream.read();
            if (map.containsKey(number)) {
                map.put(number, (map.get(number) + 1));
                if(freq < map.get(number)) freq = map.get(number);
            } else map.put(number, 1);
        }

        inputStream.close();

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue()==freq){
                result.add(entry.getKey());
            }
        }

        for (int i = 0; i <result.size() ; i++) {
            System.out.print(result.get(i)+" ");
        }
    }
}
