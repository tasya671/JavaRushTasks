package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        Map<Integer, Integer> map = new HashMap<>();

        if (args[0] != null) {
            FileInputStream inputStream = new FileInputStream(args[0]);
            int i;
            while ((i = inputStream.read()) != -1) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else
                    map.put(i, 1);
            }

            List<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return (o1.getKey()).compareTo(o2.getKey());
                }
            });

            for (Map.Entry<Integer, Integer> entry: list) {
              System.out.println((char)((int)(entry.getKey()))+" "+ entry.getValue());
            }

            inputStream.close();
        }

    }
}
