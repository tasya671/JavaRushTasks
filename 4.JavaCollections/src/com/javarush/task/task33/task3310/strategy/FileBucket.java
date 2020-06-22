package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.ExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {

    Path path;

    public FileBucket() {
        try {
            this.path = Files.createTempFile(null, null);
            Files.deleteIfExists(path);
            Files.createFile(path);
            File file = path.toFile();
            file.deleteOnExit();
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }


    public long getFileSize() {
        try {
            return Files.size(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    return 0;
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

    public void putEntry(Entry entry) {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(Files.newOutputStream(path));
            stream.writeObject(entry);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry(){
            if(getFileSize()==0)
                return null;
        try {
            ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(path));
            Entry entry = (Entry) stream.readObject();
            return entry;
        } catch (IOException | ClassNotFoundException e) {
            ExceptionHandler.log(e);
        }
        return null;
    }

}










