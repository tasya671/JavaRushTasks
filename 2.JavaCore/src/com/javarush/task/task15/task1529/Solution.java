package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    public static CanFly result;
    static {
        //add your code here - добавьте код тут

        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reset()throws IOException{
        //add your code here - добавьте код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();


        if (text.equals("helicopter")){
            result = new Helicopter();}
        if (text.equals("plane")){
            int people = Integer.parseInt(reader.readLine());
            result = new Plane(people);
        }
        reader.close();
    }
}
