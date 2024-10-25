import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int birthday;
    private Person father;
    private Person mather;
    private List<Person> children;

    public Person(String name, int birthday) {
        this.name = name;
        this.birthday = birthday;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setMather(Person mather) {
        this.mather = mather;
    }

    public boolean addChildren(Person child) {
        return children.add(child);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", father=" + father +
                ", mather=" + mather +
                ", children=" + children +
                '}';
    }

    public List<Person> getChildren() {
        return children;
    }
}
