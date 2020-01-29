package com.javarush.task.task20.task2022;

import java.io.*;
import java.lang.reflect.Field;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();

       // out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
       // in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException{

        Solution solution = new Solution("D://sol.txt");
        solution.writeObject("Привет, Андрей");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D://soll.txt"));
        objectOutputStream.writeObject(solution);
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream("D://soll.txt"));
        Solution solution1 = (Solution) stream.readObject();
        solution1.writeObject("Solnce");

    }
}
