package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        int flaganotherCat =0;
        int flagthisCat =0;

        if(this.age > anotherCat.age)
            flagthisCat++;
        else if (this.age < anotherCat.age)
            flaganotherCat++;

        if (this.weight > anotherCat.weight)
            flagthisCat++;
        else if (this.weight < anotherCat.weight)
            flaganotherCat++;

        if (this.strength > anotherCat.strength)
            flagthisCat++;
        else if (this.strength < anotherCat.strength)
            flaganotherCat++;

        return (flagthisCat>flaganotherCat);
    }

    public static void main(String[] args) {

    }
}
