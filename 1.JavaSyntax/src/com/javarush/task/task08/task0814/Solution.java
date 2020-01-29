package com.javarush.task.task08.task0814;

import java.lang.reflect.Array;
import java.util.*;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        // напишите тут ваш код
        Integer [] number ={3, 5, 9, 12, 45, 67, 77, 37, 8, 52, 29, 22, 48, 1, 7, 99, 69, 88, 11, 33};
        Set<Integer> set = new HashSet<>();
        Collections.addAll(set, number);
        return set;

    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        // напишите тут ваш код
        Iterator <Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int tem = iterator.next();
            if (tem>10)
                iterator.remove();}
        return  set;

    }

    public static void main(String[] args) {

    }
}
