package presenter;

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

    public void addStudent(String firstName, String lastName, String patronymic, LocalDate birth, String gender) {

        service.addPerson(firstName,lastName,patronymic,birth,gender);
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
    public void saveFile(){
        fileHandler.saveFile();
    }
}
