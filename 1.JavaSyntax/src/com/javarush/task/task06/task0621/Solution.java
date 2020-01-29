package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandFather = reader.readLine();
        Cat catgrandFather = new Cat(grandFather);

        String grandMother = reader.readLine();
        Cat catGrandMother = new Cat(grandMother);


        String Father = reader.readLine();
        Cat catdFather = new Cat(Father, null, catgrandFather);

        String Mother = reader.readLine();
        Cat catMother = new Cat(Mother, catGrandMother);

        String son = reader.readLine();
        Cat catSon = new Cat(son, catMother, catdFather);

        String daughter = reader.readLine();
        Cat catDaughter = new Cat(daughter, catMother, catdFather);



        System.out.println(catgrandFather);
        System.out.println(catGrandMother);
        System.out.println(catdFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;


        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mother) {
            this(name);
            this.mother = mother;
        }

        public Cat(String name, Cat mother, Cat father) {
            this(name, mother);
            this.father = father;
        }

        @Override
        public String toString() {
            if (mother == null && father ==null)
                return "The cat's name is " + name + ", no mother, no father";
            else if(mother == null && father != null)
                return "The cat's name is " + name + ", no mother, father is " + father.name;
            else if (mother != null && father == null)
                return "The cat's name is " + name + ", mother is " + mother.name + ", no father";
            else
                return "The cat's name is " + name + ", mother is " + mother.name +", father is " + father.name;

        }
    }

}
