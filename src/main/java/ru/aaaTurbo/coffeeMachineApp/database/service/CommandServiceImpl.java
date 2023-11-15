package ru.aaaTurbo.coffeeMachineApp.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aaaTurbo.coffeeMachineApp.database.entities.CommandEntity;
import ru.aaaTurbo.coffeeMachineApp.database.repo.CommandRepo;
import ru.aaaTurbo.coffeeMachineApp.util.interfaces.CommandService;

@Service
public class CommandServiceImpl implements CommandService {
    private CommandRepo repo;

    @Autowired
    public CommandServiceImpl(CommandRepo repo) {
        this.repo = repo;
    }

    @Override
    public boolean save(CommandEntity command) {
        repo.save(command);
        return true;
    }

    @Override
    public Iterable<CommandEntity> getAll() {
        return repo.findAll();
    }
}
