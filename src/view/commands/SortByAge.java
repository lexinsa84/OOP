package view.commands;

import view.ConsoleUi;

public class SortByAge extends Command {
    public SortByAge(ConsoleUi consoleUi) {
        super(consoleUi);
        description = "Отсортировать список по дате рождения";
    }

    public void execute(){
        consoleUi.getSortByBirth();
    }
}