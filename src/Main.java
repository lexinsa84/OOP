import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) throws IOException {
        FamilyTree familyTree = new FamilyTree();
        FileManageable fileManageable = new FileHandler();

        // Создаем и добавляем людей в дерево
        Person john = new Person("John", "Male", 70);
        Person mary = new Person("Mary", "Female", 68);
        Person david = new Person("David", "Male", 40);
        Person lisa = new Person("Lisa", "Female", 38);
        Person james = new Person("James", "Male", 18);

        john.addChild(david);
        mary.addChild(david);
        david.addChild(james);
        lisa.addChild(james);

        david.setFather(john);
        david.setMather(mary);
        james.setFather(david);
        james.setMather(lisa);

        familyTree.addPerson(john);
        familyTree.addPerson(mary);
        familyTree.addPerson(david);
        familyTree.addPerson(lisa);
        familyTree.addPerson(james);



        // Запись данных в файл
        String filename = "family_tree.dat";
        try {
            fileManageable.writeToFile(filename, familyTree);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

        // Чтение данных из файла
        try {
            FamilyTree loadedFamilyTree = fileManageable.readFromFile(filename);
            loadedFamilyTree.displayTree(loadedFamilyTree.findPerson("John"), 0);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при чтении из файла: " + e.getMessage());
        }
    }
}