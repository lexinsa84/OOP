package view.commands;

import view.ConsoleUi;

public class GetPersonInfo extends Command {
    public GetPersonInfo(ConsoleUi consoleUi) {
        super(consoleUi);
        description = "Получить список людей";
    }

    public void execute(){
        consoleUi.printFamilyTree();
    }
}
