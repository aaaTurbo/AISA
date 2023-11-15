package ru.aaaTurbo.coffeeMachineApp.database.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.aaaTurbo.coffeeMachineApp.database.entities.CommandEntity;

@Repository
public interface CommandRepo extends CrudRepository<CommandEntity, Long> {
}
