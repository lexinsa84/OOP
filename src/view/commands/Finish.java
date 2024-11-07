package view.commands;

import view.ConsoleUi;
import view.commands.Command;

public class Finish extends Command {
    public Finish(ConsoleUi consoleUi) {
        super(consoleUi);
        description = "Закончить работу";
    }

    public void execute() {
        consoleUi.finish();
    }
}
