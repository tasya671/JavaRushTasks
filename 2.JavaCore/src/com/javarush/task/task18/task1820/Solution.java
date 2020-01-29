package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        reader.close();


       BufferedReader reader1 = new BufferedReader(new FileReader(file1));
       BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
       String result;
       while ((result= reader1.readLine())!=null){
           String[] array = result.split(" ");
           for (int i = 0; i < array.length; i++) {
               double number = Double.valueOf(array[i]);
               int n = (int) Math.round(number);
               writer.write(Integer.toString(n)+" ");
               writer.flush();
           }
       }

       reader1.close();
       writer.close();


    }
}
