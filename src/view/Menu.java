package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<Command> commandList;

    public Menu(ConsoleUi consoleUi){
        commandList = new ArrayList<>();
        commandList.add(new AddPerson(consoleUi));
        commandList.add(new GetPersonInfo(consoleUi));
        commandList.add(new SortByName(consoleUi));
        commandList.add(new SortByAge(consoleUi));
        commandList.add(new SaveFile(consoleUi));
        commandList.add(new LoadFile(consoleUi));
        commandList.add(new Finish(consoleUi));
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
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}
