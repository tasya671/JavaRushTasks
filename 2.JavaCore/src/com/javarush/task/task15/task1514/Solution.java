package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(3.3, "vesna");
        labels.put(5.6, "nolove");
        labels.put(8.7,"life");
        labels.put(7.7, "fly");
        labels.put(8.2, "time");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
