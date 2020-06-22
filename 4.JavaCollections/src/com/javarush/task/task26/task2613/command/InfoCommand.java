package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle;

class InfoCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH +"info", Locale.ENGLISH);

    @Override
    public void execute() throws InterruptOperationException {
        Collection<CurrencyManipulator> manipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if (manipulators.size() != 0) {
            manipulators.stream().forEach(e -> {
                if (e.hasMoney()) {
                    ConsoleHelper.writeMessage(res.getString("before"));
                    ConsoleHelper.writeMessage(e.getCurrencyCode() + " - " + e.getTotalAmount());
                }
                else
                    ConsoleHelper.writeMessage(res.getString("no.money"));
            });
        } else
            ConsoleHelper.writeMessage(res.getString("no.money"));
    }
}
