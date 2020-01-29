package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{

    private static int nextId = 0;
    private int id;
    private List<Human> children = new ArrayList<>();
    protected int age;
    protected String name;
    protected Size size;
    private BloodGroup bloodGroup;

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public Human(String name, int age) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.age = age;
    }

    public class Size{
        public int height;
        public int weight;

    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void addChild (Human human){
        if(human == null) return;
        children.add(human);}

    public void removeChild (Human human){
        if(human == null) return;
        children.remove(human);
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.height);
    }

    @Override
    public void live() {  }


    public String getPosition(){
        return "Человек";
    }

    public void printData() {
        System.out.println(getPosition()+": " + name);
    }
}