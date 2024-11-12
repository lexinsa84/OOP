package view.commands;

import view.menu.MenuInvoker;

public class ShowNotesForDateCommand extends CommandImpl {


    public ShowNotesForDateCommand(MenuInvoker menuInvoker) {
        super(menuInvoker);
        description = "Показать записи на конкретный день";
    }

    @Override
    public void execute() {
        menuInvoker.ShowNotesForDate();
    }
}

