package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<FileInputStream> list = new ArrayList<>();
        String name="";

        while (true){
            try {
                name = reader.readLine();
                list.add(new FileInputStream(name));

            } catch (FileNotFoundException e ){
                System.out.println(name);
                for (FileInputStream stream:list) {
                    try {
                        stream.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                break;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
