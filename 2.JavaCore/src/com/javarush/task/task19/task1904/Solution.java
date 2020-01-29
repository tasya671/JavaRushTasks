package com.javarush.task.task19.task1904;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {


    }

    public static class PersonScannerAdapter implements PersonScanner {

        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            if (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(" ");
                SimpleDateFormat format = new SimpleDateFormat("d M yyyy");
                try {
                    Date date = format.parse(data[3] + " " + data[4] + " " + data[5]);
                    return new Person(data[1], data[2], data[0], date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}

