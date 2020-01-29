package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    //напишите тут ваш код
    public Circle(){this(0,0);};
    public Circle(double radius){
        this.x=0;
        this.y=0;
        this.radius=radius;
    }
    public Circle(double x, double y){
        this.x=x;
        this.y=y;
        this.radius=1;
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public static void main(String[] args) {

    }
}