package ru.aaaTurbo.coffeeMachineApp.util.exceptions;

public class CoffeeMachineAlreadyWorkingException extends Exception {

    public CoffeeMachineAlreadyWorkingException() {
        super("Coffee machine is working!");
    }
}
