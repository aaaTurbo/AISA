package ru.aaaTurbo.coffeeMachineApp.util.interfaces;


import ru.aaaTurbo.coffeeMachineApp.util.abstracts.Command;

public interface CommandListener {

    String execute(Command command);
}
