package ru.aaaTurbo.coffeeMachineApp.util.interfaces;

import ru.aaaTurbo.coffeeMachineApp.database.entities.CommandEntity;

public interface CommandService {
    boolean save(CommandEntity command);

    Iterable<CommandEntity> getAll();
}
