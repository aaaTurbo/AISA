package ru.aaaTurbo.coffeeMachineApp.util.abstracts;

import lombok.Getter;
import ru.aaaTurbo.coffeeMachineApp.util.interfaces.Executable;

public abstract class Command implements Executable {
    @Getter
    protected String mnemonics;

    public Command(String mnemonics) {
        this.mnemonics = mnemonics;
    }

}
