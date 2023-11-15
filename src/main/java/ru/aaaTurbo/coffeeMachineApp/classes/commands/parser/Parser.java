package ru.aaaTurbo.coffeeMachineApp.classes.commands.parser;

import org.springframework.stereotype.Component;
import ru.aaaTurbo.coffeeMachineApp.classes.commands.CleanCommand;
import ru.aaaTurbo.coffeeMachineApp.classes.commands.HeatCommand;
import ru.aaaTurbo.coffeeMachineApp.classes.commands.MakeCoffeeCommand;
import ru.aaaTurbo.coffeeMachineApp.classes.commands.StartCommand;
import ru.aaaTurbo.coffeeMachineApp.classes.commands.StopCommand;
import ru.aaaTurbo.coffeeMachineApp.util.abstracts.Command;
import ru.aaaTurbo.coffeeMachineApp.util.exceptions.WrongInputException;
import ru.aaaTurbo.coffeeMachineApp.util.interfaces.CommandParser;

@Component
public class Parser implements CommandParser {

    private static final int MNEMONICS_POS = 0;
    private static final int ARG_POS = 1;
    @Override
    public Command parse(String input) throws WrongInputException {
        input = input.replace("\"", "");
        String[] inputParts = input.split("_");
        String argument = "";
        if (inputParts.length > 2) {
            throw new WrongInputException();
        }
        String mnemonics = inputParts[MNEMONICS_POS];
        if (inputParts.length > 1) {
            argument = inputParts[ARG_POS];
        }
        switch (mnemonics){
            case "MAKE", "make" -> {
                return new MakeCoffeeCommand(argument);
            }
            case "TURN", "turn" -> {
                if (argument.equals("ON")) {
                    return new StartCommand();
                } else {
                    return new StopCommand();
                }
            }
            case "HEAT", "heat" -> {
                return new HeatCommand();
            }
            case "CLEAN", "clean" -> {
                return new CleanCommand();
            }
        }
        return null;
    }
}
