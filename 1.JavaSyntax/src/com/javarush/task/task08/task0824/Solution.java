package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human child1 = new Human("Алексей", true, 2);
        Human child2 = new Human("Варвара", false, 7);
        Human child3 = new Human("Вероника", false, 3);
        Human [] child ={child1, child2, child3};
        Human mother = new Human("Наталья", false, 50, child);
        Human father = new Human("Артем", true, 54, child);

        Human [] mutti ={mother};
        Human [] fothe ={father};


        Human grandmother1 = new Human("Зинаида", false, 72, mutti);
        Human grandfather1 = new Human("Дмитрий", true, 73, mutti);

        Human grandmother2 = new Human("Катерина", false, 76, fothe);
        Human grandfather2 = new Human("Аркадий", true, 75, fothe);


        System.out.println(grandfather1);
        System.out.println(grandmother1);
        System.out.println(grandfather2);
        System.out.println(grandmother2);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);


    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();


        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human [] child) {
            this(name, sex, age);
            for (int i = 0; i <child.length ; i++) {
                children.add(child[i]);
            }
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
