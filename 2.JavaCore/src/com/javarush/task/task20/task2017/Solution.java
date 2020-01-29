package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
        try {
            return (A) objectStream.readObject();
        }catch (NotSerializableException exp){
            exp.printStackTrace();
            return null; }
        catch (ClassNotFoundException exp){
            System.out.println(exp.getMessage());
            return null;
        } catch (IOException exp){
            System.out.println(exp.getMessage());
            return null;
        } catch (Exception exp){
            exp.printStackTrace();
            return null;
        }
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
