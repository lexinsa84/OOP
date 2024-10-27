import java.io.*;
import java.util.List;

public class FileHandler implements FileManageable{


    @Override
    public void writeToFile(String filename, FamilyTree familyTree) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(familyTree.getPeople());
            System.out.println("Данные успешно записаны в файл: " + filename);
        }
    }

    @Override
    public FamilyTree readFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Person> people = (List<Person>) ois.readObject();
            FamilyTree familyTree = new FamilyTree();
            for (Person person : people) {
                familyTree.addPerson(person);
            }
            System.out.println("Данные успешно загружены из файла: " + filename);
            return familyTree;
        }
    }
}
