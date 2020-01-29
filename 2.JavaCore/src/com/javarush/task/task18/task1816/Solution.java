package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException{

        Set<String> set = new HashSet<String>(Arrays.asList("a", "b", "c", "d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"));

        if(args.length!=0){
            try {
                BufferedInputStream reader = new BufferedInputStream(new FileInputStream(args[0]));
                int i=0;
                while (reader.available()>0){
                    if(set.contains(String.valueOf((char)reader.read()).toLowerCase())){
                        i++;
                    }
                }
                System.out.println(i);
                reader.close();


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
