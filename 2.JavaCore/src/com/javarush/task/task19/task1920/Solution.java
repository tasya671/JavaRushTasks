package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
            double max = map.get(list.get(0));
            String mname =list.get(0);
            for (int i = 0; i <list.size()-1 ; i++) {
                if(map.get(list.get(i))>max){
                    mname = list.get(i);
                    max = map.get(list.get(i));
                }
            }

            ArrayList<String> listmax = new ArrayList<>();
            for (Map.Entry<String, Double> entry: map.entrySet()) {
                if(entry.getValue()==max){
                    listmax.add(entry.getKey());

                }
            }
            Collections.sort(listmax);
            for (String nam:listmax) {
                System.out.print(nam+" ");
            }
        }
    }
}
