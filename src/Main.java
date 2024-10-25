import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Person person1 = new Person("Алексей", 1984);
        Person person2 = new Person("Анатолий", 1957);
        Person person3 = new Person("Валентина", 1957);
        Person person4 = new Person("Арсений", 2018);
        person1.setFather(person2);
        person1.setMather(person3);
        person1.addChildren(person4);


        familyTree.addPeople(person1);
        familyTree.addPeople(person2);
        familyTree.addPeople(person3);
        familyTree.addPeople(person4);

        List<Person> personListChildren = familyTree.getChildren(person1);
        for (Person child : personListChildren) {
            System.out.println(child);
            Person findByNamePerson = familyTree.findPersonByName("Анатолий");
            System.out.println(findByNamePerson);
        }
    }
}