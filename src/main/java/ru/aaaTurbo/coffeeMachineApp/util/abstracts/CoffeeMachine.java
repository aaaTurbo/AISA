package ru.aaaTurbo.coffeeMachineApp.util.abstracts;

public abstract class CoffeeMachine {
    protected boolean working = false;

    public abstract String start();

    public abstract String stop();

    public abstract String make(String action);
}
