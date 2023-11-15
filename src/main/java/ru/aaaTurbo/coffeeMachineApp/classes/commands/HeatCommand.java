package ru.aaaTurbo.coffeeMachineApp.classes.commands;

import ru.aaaTurbo.coffeeMachineApp.util.abstracts.CoffeeMachine;
import ru.aaaTurbo.coffeeMachineApp.util.abstracts.Command;

public class HeatCommand extends Command {

    public HeatCommand() {
        super("HEAT");
    }

    @Override
    public String execute(CoffeeMachine coffeeMachine) {
        return coffeeMachine.make(mnemonics);
    }

}
