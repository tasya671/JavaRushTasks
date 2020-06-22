package com.javarush.task.task33.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    private int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize;


    public FileStorageStrategy() {
        for(int i = 0; i < DEFAULT_INITIAL_CAPACITY; ++i)
            table[i] = new FileBucket();
    }

    private int hash(Long k){
        k ^= (k >>> 20) ^ (k >>> 12);
        return (int) (k ^ (k >>> 7) ^ (k >>> 4));
    }

    private int indexFor(int hash, int length){
        return (length-1) & hash;
    }

    private Entry getEntry(Long key){
        FileBucket bucket;
        int valueHash = hash(key);
        int index = indexFor(valueHash, table.length);
        if(table[index] != null && table[index].getFileSize() != 0){
                Entry entry = table[index].getEntry();
            do {
                if(entry.hash == valueHash && entry.key.equals(key))
                    return entry;
            }
            while ((entry=entry.next) != null);
        }
        return null;
    }

    private void resize(int newCapacity){
        FileBucket[] newTable = new FileBucket[newCapacity];
        for (int i = 0; i < newTable.length; i++) {
            newTable[i] = new FileBucket();
        }
        transfer(newTable);
        table = newTable;
       }

    private void transfer(FileBucket[] newTable) {
        int newCapacity = newTable.length;
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;
            Entry entry = table[i].getEntry();
            while (entry != null) {
                Entry next = entry.next;
                int indexFor = indexFor(entry.hash, newCapacity);
                entry.next = newTable[indexFor].getEntry();
                newTable[indexFor].putEntry(entry);
                entry = next;
            }
            table[i].remove();
            table[i] = null;
        }
    }

    private void addEntry(int hash, Long key, String value, int bucketIndex){
        FileBucket bucket = table[bucketIndex];
        Entry item = bucket.getEntry();
        Entry entry = new Entry(hash, key, value, item);
        bucket.putEntry(entry);
        size++;

        if(table[bucketIndex].getFileSize() > bucketSizeLimit) {
            resize(2 * table.length);
        }
    }

    private void createEntry(int hash, Long key, String value, int bucketIndex){
        //table[bucketIndex] = new FileBucket();
        table[bucketIndex].putEntry(new Entry(hash, key, value, null));
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
        FileBucket[] tab = table;
        for (int i = 0; i < tab.length; i++) {
            FileBucket bucket = tab[i];
            if(bucket!= null && bucket.getFileSize()!= 0){
                Entry entry = bucket.getEntry();
                do {
                    if(entry.value.equals(value))
                        return true;
                } while ((entry=entry.next)!= null);
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        FileBucket bucket = table[index];
        if (bucket != null && bucket.getFileSize() != 0) {
            Entry entry = bucket.getEntry();
            Entry current = bucket.getEntry();
            do {
                if (current.getKey().equals(key)) {
                    current.value = value;
                    bucket.putEntry(entry);
                    return;
                }
            } while ((current = current.next) != null);
            addEntry(hash, key, value, index);
        } else {
            createEntry(hash, key, value, index);
        }
    }

    @Override
    public Long getKey(String value) {
        FileBucket[] tab = table;
        for (int i = 0; i < tab.length; i++) {
            FileBucket bucket = tab[i];
            if(bucket != null && bucket.getFileSize()!= 0){
                Entry entry = bucket.getEntry();
                do {
                    if(entry.value.equals(value))
                        return entry.key;
                }while ((entry=entry.next)!= null);
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        Entry entry = getEntry(key);
        if (entry!= null)
            return entry.getValue();
        return null;
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }
}
