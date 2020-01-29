package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;
    public static Hippodrome game;


    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void move() {
        for (Horse horse:this.horses) {
            horse.move(); }
    }

    public void print() {
        for (Horse horse:this.horses) {
            horse.print(); }

        for (int i = 0; i <10 ; i++) {
            System.out.println();
        }
    }

    public void run() throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner(){
        Horse winner = horses.get(0);
        double maxDistance = horses.get(0).getDistance();
        for (Horse horse:this.horses) {
            if(horse.getDistance()>maxDistance){
                maxDistance = horse.getDistance();
                winner = horse; }
        }
        return winner;
    }


    public void printWinner(){
        System.out.println(String.format("Winner is %s!", getWinner().getName()));
    }

    public static void main(String[] args) throws InterruptedException {

        Hippodrome.game = new Hippodrome(new ArrayList<>());
        Horse horse1 = new Horse("Zara", 3, 0);
        Horse horse2 = new Horse("Strela", 3, 0);
        Horse horse3 = new Horse("Molnia", 3, 0);

        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);


        game.run();
        game.printWinner();

    }
}
