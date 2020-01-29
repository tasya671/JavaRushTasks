package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) {


        try {
            File file = File.createTempFile("test", null, new File("D://Somedir"));

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));



            Solution savedObject = new Solution(4);
            objectOutputStream.writeObject(savedObject);
            objectOutputStream.flush();
            objectOutputStream.close();

            Solution loadedObject = new Solution(10);
            loadedObject = (Solution) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println(savedObject.string.equals(loadedObject.string));

        }catch (ClassNotFoundException exp){
            exp.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace(); }

    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
