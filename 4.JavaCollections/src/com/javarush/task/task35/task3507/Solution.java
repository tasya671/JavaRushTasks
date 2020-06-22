package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> set = new HashSet<>();
        File [] files = new File(pathToAnimals).listFiles();
        ClassLoader loader = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                try {
                    byte[] bytes = Files.readAllBytes(Paths.get(name));
                    Class<?> cl = defineClass(null, bytes, 0, bytes.length);
                    if (cl == null) throw new ClassNotFoundException(name);
                    return cl;
                } catch (IOException e) {
                    throw  new ClassNotFoundException(name);
                }
            }
        };
        for (int i = 0; i < files.length; i++) {
            try {
                Class<?> clazz = loader.loadClass(files[i].getAbsolutePath());
                List<Class<?>> face = Arrays.asList(clazz.getInterfaces());
                List<String> inter = face.stream().map(item -> item.getSimpleName()).collect(Collectors.toList());
                if(clazz.getSimpleName().equals("Animal") || inter.contains("Animal")){
                    Animal ob = (Animal) clazz.newInstance();
                    set.add(ob);
                }
            } catch (Exception e) { }
        }
        return set;
    }
}
