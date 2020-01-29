package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        int lengh = args.length;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Person person = null;
        if (lengh==4){
            if (args[0].equals("-c")){
                if (args[2].equals("м")){
                    person = Person.createMale(args[1], format.parse(args[3])); }
                    else
                        person = Person.createFemale(args[1], format.parse(args[3]));
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            }
        }
        if (lengh==5){
            if (args[0].equals("-u")){
                if(Integer.parseInt(args[1])<=allPeople.size()-1){
                    person = allPeople.get(Integer.parseInt(args[1]));
                    person.setName(args[2]);
                    if(args[3].equals("m"))
                        person.setSex(Sex.MALE);
                    else
                        person.setSex(Sex.FEMALE);
                    person.setBirthDate(format.parse(args[4]));
                }
            }
        }
        if (lengh==2){
            if(args[0].equals("-d")){
                if(Integer.parseInt(args[1])<=allPeople.size()-1){
                    person = allPeople.get(Integer.parseInt(args[1]));
                    person.setName(null);
                    person.setSex(null);
                    person.setBirthDate(null);
                    allPeople.set(Integer.parseInt(args[1]), person);
                }
            }
            if (args[0].equals("-i")){
                if(Integer.parseInt(args[1])<=allPeople.size()-1){
                    person = allPeople.get(Integer.parseInt(args[1]));
                    String s = person.getSex().equals(Sex.MALE) ? "м" : "ж";
                    SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    System.out.println(person.getName()+" "+s+" "+format1.format(person.getBirthDate()));
                }
            }
        }

    }

}
