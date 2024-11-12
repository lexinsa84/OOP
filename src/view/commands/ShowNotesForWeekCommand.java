package view.commands;

import view.menu.MenuInvoker;

public class ShowNotesForWeekCommand extends CommandImpl{

    public ShowNotesForWeekCommand(MenuInvoker menuInvoker) {
        super(menuInvoker);
        description = "Показать записи на неделю";
    }

    @Override
    public void execute() {
        menuInvoker.showNotesForWeek();
    }
}

