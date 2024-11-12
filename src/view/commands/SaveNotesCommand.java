package view.commands;

import view.menu.MenuInvoker;

public class SaveNotesCommand extends CommandImpl{
    public SaveNotesCommand(MenuInvoker menuInvoker) {
        super(menuInvoker);
        description = "Сохранить записи в файл";
    }

    @Override
    public void execute() {
       menuInvoker.saveNotes();
    }
}

