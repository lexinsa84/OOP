import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private String name;
    private String gender;
    private int age;
    private Person father;
    private Person mather;
    private List<Person> children;
    private static final long serialVersionUID = 1L;

    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setMather(Person mather) {
        this.mather = mather;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Gender: " + gender + ", Age: " + age;
    }
}
