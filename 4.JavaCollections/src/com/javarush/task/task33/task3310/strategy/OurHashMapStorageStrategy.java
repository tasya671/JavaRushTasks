package com.javarush.task.task33.task3310.strategy;

public class OurHashMapStorageStrategy implements StorageStrategy {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;


    int hash(Long k){
        k ^= (k >>> 20) ^ (k >>> 12);
        return (int) (k ^ (k >>> 7) ^ (k >>> 4));
    }

    int indexFor(int hash, int length){
        return (length-1) & hash;
    }

    Entry getEntry(Long key){
        Entry current;
        int valueHash = hash(key);
        if(table != null & table.length > 0 &
          (current = table[indexFor(valueHash, table.length)])!= null){
                do {
                    if(current.hash == valueHash && current.key == key)
                        return current;
                }
                while ((current=current.next)!=null);
            }
        return null;
    }

    void resize(int newCapacity){
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        this.threshold = (int) (newCapacity * loadFactor);

    }

    void transfer(Entry[] newTable) {
        Entry[] oldTable = table;
        int newCapacity = newTable.length;
        for (int i = 0; i < oldTable.length; i++) {
            Entry entry = oldTable[i];
            if (entry != null) {
                oldTable[i] = null;
                do {
                    Entry next = entry.next;
                    int j = indexFor(entry.hash, newCapacity);
                    entry.next = newTable[j];
                    newTable[j] = entry;
                    entry = next;
                } while ((entry != null));
            }
        }
    }


    void addEntry(int hash, Long key, String value, int bucketIndex){
        Entry entry = table[bucketIndex];
        table[bucketIndex]= new Entry(hash, key, value, entry);
        if(size++ >= threshold){
            resize(2*table.length);
        }
    }

    void createEntry(int hash, Long key, String value, int bucketIndex){
        Entry entry = table[bucketIndex];
        table[bucketIndex]= new Entry(hash, key, value, entry);
        size++;
    }


    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        if(value == null){
            return false;
        }
        Entry[] tab = table;
        for (int i = 0; i <tab.length ; i++) {
            for (Entry entry=tab[i]; entry!=null; entry=entry.next) {
                if(value.equals(entry.value))
                    return true;
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        for (Entry entry = table[index]; entry!= null; entry=entry.next) {
            if(entry.hash == hash && (key == entry.key)){
                String oldValue = entry.value;
                entry.value = value;
            }
        }
        addEntry(hash, key, value, index);
    }

    @Override
    public Long getKey(String value) {
        Entry[] tab = table;
        for (int i = 0; i < tab.length; i++) {
            for (Entry entry = tab[i]; entry!=null; entry=entry.next) {
                if(entry.value.equals(value))
                    return entry.key;
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        for (Entry entry = table[index]; entry!=null; entry=entry.next) {
            if(entry.hash == hash && entry.key == key){
                return entry.value;
            }
        }
        return null;
    }
}
