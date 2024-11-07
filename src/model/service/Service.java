package model.service;

import model.FamilyTree;
import model.Person;
import model.util.FileHandler;

import java.time.LocalDate;

public class Service {

    FamilyTree<Person> familyTree;
    FileHandler fileHandler;

    public Service() {
        familyTree = new FamilyTree<>();
        fileHandler = new FileHandler();
    }

    public void addPerson(String firstName, String lastName, String patronymic, LocalDate birth, String gender) {
        Person person = new Person(firstName, lastName, patronymic, birth, gender);
        familyTree.addMember(person);
    }


    public String personFamilyTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей:\n");
        for (Person student : familyTree) {
            stringBuilder.append(student);
            stringBuilder.append("\n");
        }


//        Iterator<Student> iterator= StudentGroup.iterator();
//        while (iterator.hasNext()){
//            Student new_student = iterator.next();
//            stringBuilder.append(student);
//            stringBuilder.append("\n");
//        }

        return stringBuilder.toString();
    }


    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByBirthDate();
    }
}
