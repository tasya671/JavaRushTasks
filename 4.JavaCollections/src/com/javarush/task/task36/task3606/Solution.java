package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File[] files = new File(packageName).listFiles();

        ClassLoader loader = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                try {
                    byte[] classBytes = null;
                    classBytes = Files.readAllBytes(Paths.get(name));
                    Class<?> c1 = defineClass(null, classBytes, 0, classBytes.length);
                    if (c1 == null) throw new ClassNotFoundException(name);
                    return c1;
                } catch (IOException exp) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        for (int i = 0; i < files.length; i++) {
            Class<?> c = loader.loadClass(files[i].getAbsolutePath());
            if(HiddenClass.class.isAssignableFrom(c)){
                hiddenClasses.add(c);
            }
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        for (int i = 0; i <hiddenClasses.size() ; i++) {
            if(hiddenClasses.get(i).getSimpleName().toLowerCase().startsWith(key.toLowerCase())){
                try {
                    Constructor constructor = hiddenClasses.get(i).getDeclaredConstructor();
                    constructor.setAccessible(true);
                    return (HiddenClass) constructor.newInstance();
                } catch (Exception e){ }
            }
        }
        return null;
    }
}

