package ru.aaaTurbo.coffeeMachineApp.classes.commands;

import ru.aaaTurbo.coffeeMachineApp.util.abstracts.CoffeeMachine;
import ru.aaaTurbo.coffeeMachineApp.util.abstracts.Command;

public class CleanCommand extends Command {

    public CleanCommand() {
        super("CLEAN");
    }

    @Override
    public String execute(CoffeeMachine coffeeMachine) {
        return coffeeMachine.make(mnemonics);
    }

}
