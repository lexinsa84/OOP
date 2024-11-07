package view.commands;

import view.ConsoleUi;

public class SortByName extends Command {
    public SortByName(ConsoleUi consoleUi) {
        super(consoleUi);
        description = "Отсортировать людей по имени";
    }

    public void execute(){
        consoleUi.getSortByName();
    }
}
