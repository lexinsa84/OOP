package view.commands;

import view.ConsoleUi;

public class AddPerson extends Command {
    public AddPerson(ConsoleUi consoleUi){
        super(consoleUi);
        description = "Создать человека: ";
    }

    @Override
    public void execute() {
        consoleUi.addPersonInput();
    }
}
