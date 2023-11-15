package ru.aaaTurbo.coffeeMachineApp.util.exceptions;

public class WrongInputException extends Exception {
    public WrongInputException() {
        super("Wrong input! Command must have only one '_'!");
    }
}
