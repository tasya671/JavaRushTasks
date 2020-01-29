package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String namaone = reader.readLine();
        String nametwo = reader.readLine();

        reader.close();

        int count =1;

        FileReader fileReader = new FileReader(namaone);
        FileWriter fileWriter = new FileWriter(nametwo);

        while (fileReader.ready()){
            if(count%2==0){
                fileWriter.write(fileReader.read());
            } else {int c = fileReader.read();}
            count++;
        }

        fileReader.close();
        fileWriter.close();
    }
}
