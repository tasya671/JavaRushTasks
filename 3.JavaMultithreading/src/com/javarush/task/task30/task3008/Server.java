package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();


    private static class Handler extends Thread {

        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }


        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{

            Message message;
            String name;

            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                message = connection.receive();
                if(message.getType() == MessageType.USER_NAME){
                    name = message.getData();
                    if(!name.equals("") & name != null & !connectionMap.containsKey(name)){
                        connectionMap.put(name,connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        break;
                    }
                }
            }
            return name;
        }

        private void notifyUsers(Connection connection, String userName) throws IOException{
            String name;
            Message message;

            for (Map.Entry<String, Connection> entry:connectionMap.entrySet()) {
                name = entry.getKey();
                if(!name.equals(userName)){
                    message = new Message(MessageType.USER_ADDED, name);
                    connection.send(message);}
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();
                if(message.getType() == MessageType.TEXT){
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName+": "+message.getData())); }
                else
                    ConsoleHelper.writeMessage("Ошибка");
            }
        }



        public void run(){

            ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом: " + socket.getRemoteSocketAddress());
            String userName = null;
            try(Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (ClassNotFoundException | IOException e){
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом: " + socket.getRemoteSocketAddress()); }
            finally {
                if(userName!=null){
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));}
                ConsoleHelper.writeMessage("Соеденинение с удаленным адресом закрыто: " + socket.getRemoteSocketAddress());
            }


        }
    }

    public static void sendBroadcastMessage(Message message){
        for (Connection connect : connectionMap.values()) {
            try {
                connect.send(message);
            } catch (IOException e) {
                System.out.println("Cообщение не отправлено");;
            }
        }

    }


    public static void main(String[] args) {

        ConsoleHelper.writeMessage("Введите номер порта");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)){
                Socket socket;
                while (true) {
                    socket = serverSocket.accept();
                    Server.Handler handler = new Server.Handler(socket);
                    handler.start();
                }
            } catch (IOException e) { System.out.println(e); }
    }
}
