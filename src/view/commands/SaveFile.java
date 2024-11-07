package view.commands;

import view.ConsoleUi;

public class SaveFile extends Command{
    public SaveFile(ConsoleUi consoleUi){
        super(consoleUi);
        description = "Сохранить в файл: ";
    }
    @Override
    public void execute() {
        consoleUi.addPersonInput();
    }
}

