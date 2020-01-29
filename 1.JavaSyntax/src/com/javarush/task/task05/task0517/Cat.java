package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    private String name;
    private int age;
    private int weight;
    private String address;
    private String color;

    public Cat(String name) {
        this.name = name;
        this.age = 4;
        this.weight=5;
        this.color="grey";
    }
    public Cat(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight=weight;
        this.color="grey";
    }
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight=5;
        this.color="grey";
    }
    public Cat(int weight, String color) {
        this.age = 4;
        this.weight=weight;
        this.color=color;
    }
    public Cat(int weight, String color, String address) {
        this.age = 4;
        this.weight=weight;
        this.color=color;
        this.address=address;
    }

    public static void main(String[] args) {

    }
}
