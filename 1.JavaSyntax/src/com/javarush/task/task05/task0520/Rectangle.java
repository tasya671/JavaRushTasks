package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    //напишите тут ваш код
    private int top;
    private int left;
    private int width;
    private int height;


    public Rectangle(Rectangle another){
        this.top = another.top;
        this.left =another.left;
        this.height= another.height;
        this.width=another.width;
    }

    public Rectangle(int top, int left, int width){
        this.top = top;
        this.left=left;
        this.width=width;
        this.height=width;
    }
    public Rectangle(int top, int left, int width, int height){
        this.top = top;
        this.left=left;
        this.width=width;
        this.height=height;
    }
    public Rectangle(int top, int left){
        this.top = top;
        this.left=left; }

    public static void main(String[] args) {

    }
}
