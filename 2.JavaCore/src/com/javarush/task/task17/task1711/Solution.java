package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Person person = null;

        switch (args[0]) {

            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        if (args[i + 1].equals("м")) {
                            person = Person.createMale(args[i], format.parse(args[i + 2]));
                        } else
                            person = Person.createFemale(args[i], format.parse(args[i + 2]));
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                }
                break;

            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        if (Integer.parseInt(args[i]) <= allPeople.size() - 1) {
                            person = allPeople.get(Integer.parseInt(args[i]));
                            person.setName(args[i + 1]);
                            if (args[i + 2].equals("м"))
                                person.setSex(Sex.MALE);
                            else
                                person.setSex(Sex.FEMALE);
                            person.setBirthDate(format.parse(args[i + 3]));
                        }
                    }
                }
                break;

            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        if (Integer.parseInt(args[i]) <= allPeople.size() - 1) {
                            person = allPeople.get(Integer.parseInt(args[i]));
                            person.setName(null);
                            person.setSex(null);
                            person.setBirthDate(null);
                            allPeople.set(Integer.parseInt(args[i]), person);
                        }
                    }
                }
                break;

            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        if (Integer.parseInt(args[i]) <= allPeople.size() - 1) {
                            person = allPeople.get(Integer.parseInt(args[i]));
                            String s = person.getSex().equals(Sex.MALE) ? "м" : "ж";
                            SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                            System.out.println(person.getName() + " " + s + " " + format1.format(person.getBirthDate()));
                        }
                    }
                }
                break;
        }

    }
}
