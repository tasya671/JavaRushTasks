package com.javarush.task.task39.task3906;

public class ElectricPowerSwitch {
    private Switchable switchableSystem;

    public ElectricPowerSwitch(Switchable securitySystem) {
        this.switchableSystem = securitySystem;
    }

    public void press() {
        System.out.println("Power switch flipped.");
        if (switchableSystem.isOn()) {
            switchableSystem.turnOff();
        } else {
            switchableSystem.turnOn();
        }
    }
}
