package com.javarush.task.task08.task0813;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 
20 слов на букву «Л»
*/

public class Solution {
    public static Set<String> createSet() {
        //напишите тут ваш код
        String [] text ={"Лук", "Лес", "Любовь", "Лак", "Лом", "Лира", "Лакмус", "Лотерея", "Лето", "Лига",
        "Ласка", "Лопасть", "Луг", "Лото", "Лиса", "Ласточка", "Лимон", "Ласты", "Литература", "Лось"};
        Set <String> set = new HashSet<>();
        Collections.addAll(set, text);
        return set;

    }

    public static void main(String[] args) {

    }
}
