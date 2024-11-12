package view.commands;

import view.menu.MenuInvoker;

public class FinishCommand extends CommandImpl{
    public FinishCommand(MenuInvoker menuInvoker){
        super(menuInvoker);
        description = "Выйти";
    }
    @Override
    public void execute() {
        menuInvoker.finish();
    }
}
