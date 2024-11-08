package presenter;

import model.FamilyTree;
import model.service.Service;
import model.util.FileHandler;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private final View view;
    private final Service service;
    private final FileHandler fileHandler;
//private List<Person>members;
    public Presenter(View consoleView) {
        service = new Service();
        view = consoleView;
        fileHandler = new FileHandler();
    }

    public void addPerson(String name, LocalDate birth, String gender) {

        service.addPerson(name, birth, gender);
        view.printAnswer("Человек добавлен с список!");
    }

    public void printPersonInfo() {
        String personInfo = service.personFamilyTreeInfo();
        view.printAnswer(personInfo);
    }

    public void sortByName() {
        service.sortByName();
        printPersonInfo();
    }


    public void sortByAge() {
        service.sortByAge();
        printPersonInfo();
    }
    public void saveFile(FamilyTree<?> familyTree,String filePath){
        fileHandler.saveFile(familyTree,filePath);
    }
    public void loadFile(String filePath){
        fileHandler.loadFile(filePath);
    }
}
