import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable{
    private List<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }

    public Person findPerson(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public void displayTree(Person person, int generation) {
        if (person == null) return;

        String indent = " ".repeat(generation * 4);
        System.out.println(indent + person);

        for (Person child : person.getChildren()) {
            displayTree(child, generation + 1);
        }
    }
}
