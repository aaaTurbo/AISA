package ru.aaaTurbo.coffeeMachineApp.util.interfaces;

import ru.aaaTurbo.coffeeMachineApp.util.abstracts.Command;
import ru.aaaTurbo.coffeeMachineApp.util.exceptions.WrongInputException;

public interface CommandParser {
    Command parse(String input) throws WrongInputException;
}
