package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        BufferedWriter fileOutputStream = new BufferedWriter(new FileWriter(file));

        while (true){
            String text = reader.readLine();
            fileOutputStream.write(text+"\r\n");
            if (text.equals("exit"))
                break;
        }

        reader.close();
        fileOutputStream.close();

        //BufferedReader reader1 = new BufferedReader(new FileReader(file));



        //String line;
        //while ((line = reader1.readLine())!=null){
         //   System.out.println(line);
        //}

        //reader.close();

    }
}
