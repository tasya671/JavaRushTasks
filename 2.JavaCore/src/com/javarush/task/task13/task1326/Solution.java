package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();


        FileInputStream inputStream = new FileInputStream(new File(file));


        Scanner sc = new Scanner(inputStream);
        ArrayList<Integer> list = new ArrayList<>();


        while (sc.hasNext()){
            Integer l = sc.nextInt();
            if (l%2==0)
                list.add(l);
        }
        reader.close();
        sc.close();

        Collections.sort(list);
        for (Integer i: list) {
            System.out.println(i); }


    }
}
