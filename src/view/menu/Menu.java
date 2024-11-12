package view.menu;

import java.util.ArrayList;
import java.util.List;

import view.commands.*;
public class Menu {
    List<CommandImpl> commandList;

    public Menu(MenuInvoker menuInvoker){
        commandList = new ArrayList<>();
        commandList.add(new AddNoteCommand(menuInvoker));
        commandList.add(new ShowNotesForDateCommand(menuInvoker));
        commandList.add(new ShowNotesForWeekCommand(menuInvoker));
        commandList.add(new SaveNotesCommand(menuInvoker));
        commandList.add(new LoadNotesCommand(menuInvoker));
        commandList.add(new FinishCommand(menuInvoker));
    }

    String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        CommandImpl command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}
