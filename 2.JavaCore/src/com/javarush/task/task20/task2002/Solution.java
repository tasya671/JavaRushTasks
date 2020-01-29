package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("temptxt", null, new File("D://SomeDir"));
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User is = new User();
            is.setFirstName("Игорь");
            is.setLastName("Воскресенский");
            is.setBirthDate(new Date());
            is.setCountry(User.Country.RUSSIA);
            is.setMale(true);
            javaRush.users.add(is);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

          //  outputStream.close();
           // inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintStream stream = new PrintStream(outputStream);
            if(users != null){
                for (User  us: users) {
                    stream.println(us.getFirstName());
                    stream.println(us.getLastName());
                    stream.println(us.getBirthDate().getTime());
                    stream.println(us.isMale());
                    stream.println(us.getCountry());
                }

            }
            stream.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String first = "";
            while ((first =reader.readLine())!=null){
                User current = new User();
                current.setFirstName(first);
                current.setLastName(reader.readLine());
                current.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                current.setMale(Boolean.valueOf(reader.readLine()));
                String name =reader.readLine().replaceAll("\n\r","");
                current.setCountry(User.Country.valueOf(name));
                users.add(current);
            }

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
