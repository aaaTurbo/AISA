package ru.aaaTurbo.coffeeMachineApp.classes.commands.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.aaaTurbo.coffeeMachineApp.classes.MyCoffeeMachine;
import ru.aaaTurbo.coffeeMachineApp.util.abstracts.Command;
import ru.aaaTurbo.coffeeMachineApp.util.interfaces.CommandListener;

@Component
public class MyCommandListener implements CommandListener {
    private MyCoffeeMachine coffeeMachine;

    @Autowired
    public MyCommandListener(MyCoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public String execute(Command command) {
        return command.execute(coffeeMachine);
    }
}
