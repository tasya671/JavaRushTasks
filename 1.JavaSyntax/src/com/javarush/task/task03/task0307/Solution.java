package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Zerg zerg1 = new Zerg();
        zerg1.name = "Zebra";
        Zerg zerg2 = new Zerg();
        zerg2.name = "Zubr";
        Zerg zerg3 = new Zerg();
        zerg3.name = "Zmeya";
        Zerg zerg4 = new Zerg();
        zerg4.name = "Zaic";
        Zerg zerg5 = new Zerg();
        zerg5.name = "Zaxar";

        Protoss protoss1 = new Protoss();
        protoss1.name = "Pilot";
        Protoss protoss2 = new Protoss();
        protoss2.name = "Picachu";
        Protoss protoss3 = new Protoss();
        protoss3.name = "Piton";


        Terran terran1 = new Terran();
        terran1.name = "Tutanhamon";
        Terran terran2 = new Terran();
        terran2.name = "Tuk-tuk";
        Terran terran3 = new Terran();
        terran3.name = "Timoti";
        Terran terran4 = new Terran();
        terran4.name = "Truten'";
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
