package ru.aaaTurbo.coffeeMachineApp.classes.commands;

import ru.aaaTurbo.coffeeMachineApp.util.abstracts.CoffeeMachine;
import ru.aaaTurbo.coffeeMachineApp.util.abstracts.Command;

public class StopCommand extends Command {

    public StopCommand() {
        super("TURN_OFF");
    }

    @Override
    public String execute(CoffeeMachine coffeeMachine) {
        return coffeeMachine.stop();
    }

}
