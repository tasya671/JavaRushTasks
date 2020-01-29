package com.javarush.task.task14.task1419;

import java.io.FileNotFoundException;
import java.net.SocketException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e); }

        //напишите тут ваш код
        try {
            throw new RuntimeException();
        } catch (RuntimeException exp){
            exceptions.add(exp); }
        try {
            throw new IndexOutOfBoundsException();
        } catch (IndexOutOfBoundsException exp){
            exceptions.add(exp); }
        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException exp){
            exceptions.add(exp); }
        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException exp){
            exceptions.add(exp); }
        try {
            throw new NumberFormatException();
        } catch (NumberFormatException exp){
            exceptions.add(exp); }
        try {
            throw new SocketException();
        } catch (SocketException exp){
            exceptions.add(exp); }
        try {
            throw new FileNotFoundException();
        } catch (FileNotFoundException exp){
            exceptions.add(exp); }
        try {
            throw new ArrayStoreException();
        } catch (ArrayStoreException exp){
            exceptions.add(exp); }
        try {
            throw new InstantiationException();
        } catch (InstantiationException exp){
            exceptions.add(exp); }


    }
}
