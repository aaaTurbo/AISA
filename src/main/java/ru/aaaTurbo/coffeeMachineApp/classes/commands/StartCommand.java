package ru.aaaTurbo.coffeeMachineApp.classes.commands;

import ru.aaaTurbo.coffeeMachineApp.util.abstracts.CoffeeMachine;
import ru.aaaTurbo.coffeeMachineApp.util.abstracts.Command;

public class StartCommand extends Command {

    public StartCommand() {
        super("TURN_ON");
    }

    @Override
    public String execute(CoffeeMachine coffeeMachine) {
        return coffeeMachine.start();
    }

}
