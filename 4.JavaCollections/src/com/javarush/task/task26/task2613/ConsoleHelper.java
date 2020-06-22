package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConsoleHelper {

    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH +"common", Locale.ENGLISH);

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        try {
            String str = bis.readLine();
            if (str.equalsIgnoreCase("EXIT"))
                throw new InterruptOperationException();
            return str;
        } catch (IOException e) { }
        return null;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        String currency = readString();
        while (!currency.matches("[A-Za-z]{3}")) {
            writeMessage(res.getString("invalid.data"));
            writeMessage(res.getString("choose.currency.code"));
            currency = readString();
        }
        return currency.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        String content = readString();
        while (true){
            if (content.matches("(\\+)?\\d+\\s(\\+)?\\d+")){
                String[] data = content.split(" ");
                return new String[]{data[0], data[1]};
            } else {
                writeMessage(res.getString("invalid.data"));
                writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
                content = readString();
            }
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        writeMessage(res.getString("choose.operation"));
        Operation [] operations = Operation.values();
        for (int i = 1; i < operations.length; i++) {
            writeMessage(i +" - "+ res.getString("operation."+operations[i].name()));
        }
        String number = readString();
        while (true){
            if(number.matches("\\d+")){
                 int n = Integer.parseInt(number);
                 try {
                     Operation current = Operation.getAllowableOperationByOrdinal(n);
                     return current;
                 } catch (IllegalArgumentException exp){
                     writeMessage(res.getString("invalid.data"));
                     writeMessage(res.getString("choose.operation"));
                     number = readString();
                 }
            } else {
                writeMessage(res.getString("invalid.data"));
                writeMessage(res.getString("choose.operation"));
                number = readString();
            }
        }
    }

    public static void printExitMessage(){
        writeMessage(res.getString("the.end"));
    }

}

