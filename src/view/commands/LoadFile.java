package view.commands;

import view.ConsoleUi;

public class LoadFile extends Command{
    public LoadFile(ConsoleUi consoleUi){
        super(consoleUi);
        description = "Загрузить файл:";
    }

    @Override
    public void execute() {
        consoleUi.loadFilePath();
    }
}
