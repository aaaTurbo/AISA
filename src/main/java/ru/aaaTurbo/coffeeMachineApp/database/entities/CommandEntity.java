package ru.aaaTurbo.coffeeMachineApp.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
public class CommandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Getter
    private String commandType;
    @Getter
    private String time;
    @Getter
    private String status;

    public CommandEntity(String commandType, String status) {
        this.commandType = commandType;
        this.time = new Date().toString();
        this.status = status;
    }

    @Override
    public String toString() {
        return "Command " +
                commandType +
                " was executed at " +
                time +
                " with status: " +
                status;
    }
}
