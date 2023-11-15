package ru.aaaTurbo.coffeeMachineApp.util.exceptions;

public class CoffeeMachineOfflineException extends Exception{

    public CoffeeMachineOfflineException() {
        super("Coffee machine is offline! Turn it on!");
    }
}
