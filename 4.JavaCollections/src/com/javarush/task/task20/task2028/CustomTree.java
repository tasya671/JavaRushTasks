package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;
import java.lang.String;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;
    private int count = 0;


    public CustomTree() {
        this.root = new Entry<>("root");
    }

    @Override
    public String get(int index) {
         throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }


    public boolean add(String s){
        Entry<String> node = new Entry<>(s);
        if (root == null){
            root = node;
            count =1;
            return  true;
        }
        Entry<String> current = root;
        Queue<Entry> queue = new LinkedList<>();

        do {
            if (current.leftChild != null)
                queue.add(current.leftChild);
            else {
                if (current.availableToAddLeftChildren)
                {
                current.leftChild = node;
                node.parent = current;
                count++;
                return true;}
            }
            if (current.rightChild != null)
                queue.add(current.rightChild);
            else { if (current.availableToAddRightChildren)
            {
                current.rightChild = node;
                node.parent = current;
                count++;
                return true;}
            }
            if (!queue.isEmpty())
                current = queue.poll();
        } while (!queue.isEmpty());


        if ((Math.log(size()+2)/Math.log(2))%1==0){
            current = root;
            do {
                if (current.leftChild != null)
                    queue.add(current.leftChild);
                else if (!(current.availableToAddLeftChildren))
                    current.availableToAddLeftChildren = true;
                if (current.rightChild != null)
                    queue.add(current.rightChild);
                else if (!current.availableToAddRightChildren)
                    current.availableToAddRightChildren = true;
                if (!queue.isEmpty())
                    current = queue.poll();
            }
                    while (!queue.isEmpty());

             return add(s);
        }
        return false;
    }

    public boolean remove(Object o)throws UnsupportedOperationException{

        if (!(o instanceof String)){
            throw new UnsupportedOperationException(); }

        if (root == null)
            return false;
        Entry<String> current = root;
        Stack <Entry> stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            if (!stack.isEmpty()) {
                current = stack.pop(); }

            while (current != null) {
                if (current.elementName.equals(o)){
                    if (current.parent.rightChild == current){
                        current.parent.rightChild = null;
                        current.parent.availableToAddRightChildren = false;
                    }
                    else{
                        current.parent.leftChild = null;
                        current.parent.availableToAddLeftChildren = false;
                    }

                    count--;
                    return true;
                }
                if (current.rightChild != null) stack.push(current.rightChild);
                current = current.leftChild;
            }

        }


        return false;
    }



    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }


    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {

    this.count = -1;
    if (root == null)
        return 0;
        Entry<String> current = root;
        Stack <Entry> stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            if (!stack.isEmpty()) {
                current = stack.pop();
            }

            while (current != null) {
                count++;
                if (current.rightChild != null) stack.push(current.rightChild);
                current = current.leftChild;
            }
        }
        return count;
    }


    public String getParent(String s){
        if (root == null) return null;
        Entry<String> current = root;
        Stack <Entry> stack = new Stack<>();

        while (current != null || !stack.isEmpty()){
            if(!stack.isEmpty()){
                current =stack.pop();
            }

            while (current!= null){
                if (current.elementName.equals(s))
                    return current.parent.elementName;
                if (current.rightChild != null) stack.push(current.rightChild);
                current = current.leftChild;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Entry<String> current = root;
        Queue<Entry> queue = new LinkedList<>();
        do {
            stringBuilder.append(current.elementName);
            stringBuilder.append(" ");
            if (current.leftChild != null)
                queue.add(current.leftChild);
            if (current.rightChild != null)
                queue.add(current.rightChild);
                current = queue.poll();
        } while (current!=null);


        return stringBuilder.toString();
    }

    static class Entry<T> implements Serializable {

        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;


        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }


        public boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren | availableToAddRightChildren;
        }
    }

}
