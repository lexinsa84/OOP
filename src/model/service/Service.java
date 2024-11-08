package model.service;

import model.FamilyTree;
import model.Person.Person;
import model.util.FileHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class

Service {

    FamilyTree<Person> familyTree;
    FileHandler fileHandler;

    public Service() {
        familyTree = new FamilyTree<>();
        fileHandler = new FileHandler();
    }

    public void addPerson(String name, LocalDate birth, String gender) {
        Person person = new Person(name, birth, gender);
        familyTree.addMember(person);
    }

    public String personFamilyTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей:\n");
        for (Person person : familyTree) {
            stringBuilder.append(person);
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }


    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByBirthDate();
    }
}
