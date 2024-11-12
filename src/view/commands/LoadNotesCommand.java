package view.commands;

import view.menu.MenuInvoker;

public class LoadNotesCommand extends CommandImpl {

    public LoadNotesCommand(MenuInvoker menuInvoker) {
        super(menuInvoker);
        description = "Загрузить записи из файла";
    }

    @Override
    public void execute() {
        menuInvoker.loadNotes();
    }
}

