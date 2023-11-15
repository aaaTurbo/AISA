package ru.aaaTurbo.coffeeMachineApp.classes;

import org.springframework.stereotype.Component;
import ru.aaaTurbo.coffeeMachineApp.util.abstracts.CoffeeMachine;
import ru.aaaTurbo.coffeeMachineApp.util.exceptions.CoffeeMachineAlreadyWorkingException;
import ru.aaaTurbo.coffeeMachineApp.util.exceptions.CoffeeMachineOfflineException;

import java.util.Date;

@Component
public class MyCoffeeMachine extends CoffeeMachine {

    @Override
    public String start() {
        try {
            if (working) {
                throw new CoffeeMachineAlreadyWorkingException();
            } else {
                working = true;
                return "DONE!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String stop() {
        try {
            if (!working) {
                throw new CoffeeMachineOfflineException();
            } else {
                working = true;
                return "DONE!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String make(String action) {
        try {
            if (!working) {
                throw new CoffeeMachineOfflineException();
            } else {
                return "DONE!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
