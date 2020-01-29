package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

import javax.swing.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код

        Human women1 = new Human("Ира", false, 67);
        Human women2 = new Human("Соня", false, 56);
        Human man1 = new Human("Кирилл", true, 70);
        Human man2 = new Human("Петр", true, 55);

        Human child1 = new Human("Виктор", true, 40, man1, women1);
        Human child12 = new Human("Елена", false, 32, man1, women1);

        Human child13 = new Human("Петя", true, 28, man2, women2);

        Human child14 = new Human("Саша", true, 3, child13, child12);
        Human child15 = new Human("Варвара", false, 1, child13, child12);

        ArrayList<Human> list = new ArrayList<>();
        list.add(women1);
        list.add(women2);
        list.add(man1);
        list.add(man2);
        list.add(child1);
        list.add(child12);
        list.add(child13);
        list.add(child14);
        list.add(child15);

        for (Human human:list) {
            System.out.println(human); }

    }

    public static class Human {
        // напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private  Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this(name, sex, age);
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}