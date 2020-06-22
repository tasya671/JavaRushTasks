package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;


public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;



    public AmigoSet() {
        map = new HashMap<>();
    }


    public AmigoSet(Collection<? extends E> collection) {
        int capacity = Math.max(16, (int) Math.ceil(collection.size()/.75f));
        map = new HashMap<>(capacity);
        addAll(collection);

    }

    @Override
    public boolean add(E e) {
        if(!map.containsKey(e)) {
            map.put(e, PRESENT);
            return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        Set<E> keySet = map.keySet();
        return keySet.iterator();
    }

    @Override
    public int size() {
        return map.size();
    }


    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        Object remove = map.remove(o);
        if (remove != null)
            return true;
        return false;
    }

    @Override
    public void clear() {
        map.clear();
    }


    @Override
    public Object clone() throws InternalError {
        try {
            HashMap keys =(HashMap) map.clone();
            Collection clone = keys.keySet();
            AmigoSet set = new AmigoSet(clone);
            return set;
        } catch (Exception e){
            throw new InternalError(e.getMessage());
        }
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        stream.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        stream.writeInt(map.size());
        for(E e : this.map.keySet()){
            stream.writeObject(e);
        };
        stream.flush();
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        int capacity = stream.readInt();
        float loadFactor = stream.readFloat();
        int size = stream.readInt();
        map = new HashMap(capacity, loadFactor);
        for (int i = 0; i < size; i++) {
            map.put((E) stream.readObject(), PRESENT);
        }
    }
}
