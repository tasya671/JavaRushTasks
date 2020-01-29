package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

import java.util.Date;

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private String lastName;
        private int age;
        private Date dateOfBirth;
        private double height;
        private boolean sex;


        // Напишите тут ваши переменные и конструкторы

        public Human(String name, String lastName, int age) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
        }

        public Human(String name, Date dateOfBirth, boolean sex) {
            this.name = name;
            this.dateOfBirth = dateOfBirth;
            this.sex = sex;
        }

        public Human(String name, Date dateOfBirth, double height, boolean sex) {
            this.name = name;
            this.dateOfBirth = dateOfBirth;
            this.height = height;
            this.sex = sex;
        }

        public Human(String lastName, int age) {
            this.lastName = lastName;
            this.age = age;
        }

        public Human(String lastName, int age, boolean sex) {
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, Date dateOfBirth, double height) {
            this.name = name;
            this.dateOfBirth = dateOfBirth;
            this.height = height;
        }

        public Human(String name, String lastName, int age, boolean sex) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, int age, Date dateOfBirth, double height, boolean sex) {
            this.name = name;
            this.age = age;
            this.dateOfBirth = dateOfBirth;
            this.height = height;
            this.sex = sex;
        }

        public Human(String name, String lastName, Date dateOfBirth, boolean sex) {
            this.name = name;
            this.lastName = lastName;
            this.dateOfBirth = dateOfBirth;
            this.sex = sex;
        }

        public Human(String name, String lastName, int age, Date dateOfBirth, double height, boolean sex) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.dateOfBirth = dateOfBirth;
            this.height = height;
            this.sex = sex;
        }
    }
}
