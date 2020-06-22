package com.javarush.task.task40.task4006;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        try {

            Socket socket = new Socket(url.getHost(), 80);

            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write(String.format("GET %s HTTP/1.1\r\n", url.getPath()));
            writer.write(String.format("Host: %s\r\n", url.getHost()));
            writer.write("Connection: close\r\n\r\n");
            writer.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String content;
            while ((content = reader.readLine())!= null){
                System.out.println(content);
            }

            writer.close();
            reader.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}