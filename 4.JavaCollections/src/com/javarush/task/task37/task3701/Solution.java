package com.javarush.task.task37.task3701;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.function.Consumer;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();
    }

    public class RoundIterator implements Iterator<T> {

        private Iterator<T> iterator;

        public RoundIterator() { this.iterator = Solution.super.iterator();}

//        @SuppressWarnings("unchecked")
//        @Override
//        public boolean hasNext() {
//            return true;
//        }

//        @Override
//        public T next() {
//            T obj = iterator.next();
//            try {
//                Field cursor = iterator.getClass().getDeclaredField("cursor");
//                cursor.setAccessible(true);
//                if(cursor.getInt(iterator) >= size()){
//                    cursor.set(iterator, 0);
//                }
//            } catch (NoSuchFieldException | IllegalAccessException e){}
//            return obj;
//        }
//
//        @Override
//        public void remove() {
//            iterator.remove();
//        }
//
//        @Override
//        public void forEachRemaining(Consumer<? super T> action) {
//            iterator.forEachRemaining(action);
//        }
        @Override
        public boolean hasNext() { return (Solution.this.size() > 0);}
        @Override
        public T next() {
            if (!iterator.hasNext()) iterator = Solution.super.iterator();
            return iterator.next();
        }
        @Override
        public void remove() {iterator.remove();}
    }
}
