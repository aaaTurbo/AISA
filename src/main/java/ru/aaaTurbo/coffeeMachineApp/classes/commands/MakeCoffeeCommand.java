package ru.aaaTurbo.coffeeMachineApp.classes.commands;

import ru.aaaTurbo.coffeeMachineApp.util.abstracts.CoffeeMachine;
import ru.aaaTurbo.coffeeMachineApp.util.abstracts.Command;

public class MakeCoffeeCommand extends Command {


    public MakeCoffeeCommand() {
        super("MAKE");
    }

    public MakeCoffeeCommand(String coffee) {
        super("MAKE_" + coffee);
    }

    @Override
    public String execute(CoffeeMachine coffeeMachine) {
        return coffeeMachine.make(mnemonics);
    }

}
