package view.commands;
import view.menu.MenuInvoker;


public class AddNoteCommand extends CommandImpl {
    public AddNoteCommand(MenuInvoker menuInvoker) {
        super(menuInvoker);
        description = "Добавить запись";
    }

    @Override
    public void execute() {
        menuInvoker.addNotes();
    }
}
