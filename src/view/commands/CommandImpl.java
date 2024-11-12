package view.commands;

import view.menu.MenuInvoker;

public abstract class CommandImpl{
    String description;
    MenuInvoker menuInvoker;

    public CommandImpl(MenuInvoker menuInvoker) {
        this.menuInvoker=menuInvoker;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}
