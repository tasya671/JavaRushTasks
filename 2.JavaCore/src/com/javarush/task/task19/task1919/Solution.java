package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws IOException {

        Map<String, Double> map = new HashMap<>();

        if (args[0]!=null){
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            while (reader.ready()){
                String [] data = reader.readLine().split(" ");
                if(data.length==2){
                    if(map.containsKey(data[0])){
                    map.put(data[0],(map.get(data[0])+Double.parseDouble(data[1])));}
                    else map.put(data[0],Double.parseDouble(data[1]));
                }
            }
            reader.close();
            ArrayList<String> list=new ArrayList<>(map.keySet());
            Collections.sort(list);
            for (String name:list) {
                System.out.println(name+" "+map.get(name));
            }
        }
    }
}
