package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

       Map<String, String> map = new LinkedHashMap<>();
      map.put("name", null);
       map.put("country", null);
        map.put("city","Kiev");
        map.put("age", null);
        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String,String> entry:params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value != null){
                builder.append(key+" = '");
                builder.append(value+"' and ");
            }
        }
        if(builder.length()>5){
        builder.delete(builder.length()-5, builder.length());}
        return builder.toString();
    }
}
