package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //ввести с консоли несколько ключей (строк), пункт 7
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key;
        Movie movie = null;

        while (true){
            key = reader.readLine();
            if (key.equalsIgnoreCase("cartoon") || key.equalsIgnoreCase("soapOpera") || key.equalsIgnoreCase("thriller")){
                movie = MovieFactory.getMovie(key);
                System.out.println(movie.getClass().getSimpleName());
            }
            else {
                movie = MovieFactory.getMovie(key);
                break;
            }
        }

        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key))
                movie = new SoapOpera();
            if ("cartoon".equalsIgnoreCase(key))
                movie = new Cartoon();
            if ("thriller".equalsIgnoreCase(key))
                movie = new Thriller();


            //напишите тут ваш код, пункты 5,6

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends  Movie {
    }

    static  class Thriller extends Movie {

    }

    //Напишите тут ваши классы, пункт 3
}
