package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Man man1 = new Man("Igor", 27, "Balakireva-31-14");
        Man man2 = new Man("Sasha", 28, "Zarya-17");
        System.out.println(man1);
        System.out.println(man2);
        Woman woman1 = new Woman("Yuli", 25, "Karagonda");
        Woman woman2 = new Woman("Nastja", 28, "Balakireva_28");
        System.out.println(woman1);
        System.out.println(woman2);

    }

    //напишите тут ваш код
    public static class Man{
        private String name;
        private int age;
        private String address;

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getAddress() {
            return address;
        }

        public String toString(){
            return this.getName()+" "+this.getAge()+" "+this.getAddress();
        }
    }

    public static class Woman{
        private String name;
        private int age;
        private String address;

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getAddress() {
            return address;
        }

        public String toString(){
            return this.getName()+" "+this.getAge()+" "+this.getAddress();
        }
    }
}
