package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        int key = 35;

        if(args.length!=0){


            switch (args[0]){

                case "-e":
                {
                    try {
                        FileInputStream inputStream = new FileInputStream(args[1]);
                        FileOutputStream outputStream = new FileOutputStream(args[2]);

                        while (inputStream.available()>0){
                            int i = inputStream.read()+key;
                            outputStream.write(i);
                        }
                        outputStream.flush();
                        inputStream.close();
                        outputStream.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }


                    break;
                }
                case "-d":
                {
                    try {
                        FileInputStream inputStream = new FileInputStream(args[1]);
                        FileOutputStream outputStream = new FileOutputStream(args[2]);

                        while (inputStream.available()>0){
                            int i = inputStream.read()-key;
                            outputStream.write(i);
                        }
                        outputStream.flush();
                        inputStream.close();
                        outputStream.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }

            }
        }

    }

}
