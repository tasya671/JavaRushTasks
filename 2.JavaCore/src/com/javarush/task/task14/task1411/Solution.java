package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key;



        Person person = null;


        //тут цикл по чтению ключей, пункт 1
        while (true){
            key = reader.readLine();
            if (key.equalsIgnoreCase("User"))
                person = new Person.User();
            else if (key.equalsIgnoreCase("Loser"))
                person = new Person.Loser();
            else if (key.equalsIgnoreCase("Coder"))
                person = new Person.Coder();
            else if (key.equalsIgnoreCase("Proger"))
                person = new Person.Proger();
            else break;
            doWork(person); //вызываем doWork

        }
        reader.close();
    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User)
            ((Person.User) person).live();
        if (person instanceof Person.Loser)
            ((Person.Loser) person).doNothing();
        if (person instanceof Person.Coder)
            ((Person.Coder) person).writeCode();
        if (person instanceof Person.Proger)
            ((Person.Proger) person).enjoy();
    }
}
