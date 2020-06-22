package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH  +"login", Locale.ENGLISH);
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH +"verifiedCards");

    @Override
    public void execute() throws InterruptOperationException {
            ConsoleHelper.writeMessage(res.getString("before"));
            ConsoleHelper.writeMessage(res.getString("specify.data"));
        while (true) {
            String cardNumber = ConsoleHelper.readString();
            String cardPin = ConsoleHelper.readString();

            if (cardNumber.matches("\\d{12}") && cardPin.matches("\\d{4}")) {
                if (validCreditCards.containsKey(cardNumber) && validCreditCards.getString(cardNumber).equals(cardPin)) {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNumber));
                    return;
                } else {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNumber));
                }
            } else {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
            ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
        }
    }
}
