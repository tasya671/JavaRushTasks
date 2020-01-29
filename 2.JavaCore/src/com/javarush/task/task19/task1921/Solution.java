package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        if (args[0] != null) {

            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            SimpleDateFormat format = new SimpleDateFormat("d M yyyy");
            while (reader.ready()) {
                String[] data = reader.readLine().split(" ");
                String name = "";
                int[] day = new int[3];
                for (int i = 0; i < data.length; i++) {
                    try {
                        for (int j = 0; j < day.length; j++) {
                            day[j] = Integer.parseInt(data[i]);
                            i++;
                        }
                    } catch (NumberFormatException exp) {
                        name += data[i]+" ";
                    }
                }
                try {
                    Date date = format.parse(Integer.toString(day[0])+" "+Integer.toString(day[1])+" "+Integer.toString(day[2]));
                    PEOPLE.add(new Person(name.substring(0,name.length()-1), date));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            reader.close();
        }
    }
}
