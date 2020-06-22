package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

class DepositCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH  +"deposit", Locale.ENGLISH);

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currency = ConsoleHelper.askCurrencyCode();
        String[] data = ConsoleHelper.getValidTwoDigits(currency);
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);
        manipulator.addAmount(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), Integer.parseInt(data[0])*Integer.parseInt(data[1]), manipulator.getCurrencyCode()));
    }
}
