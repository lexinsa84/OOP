
import model.FamilyTree;
import model.Person;
import model.util.FileHandler;
import view.ConsoleUi;

import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
//        FamilyTree<Person> familyTree = new FamilyTree<>();
//
//        // Создаем несколько членов семьи
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//            Person father = new Person("Анатолий", "Андреев", "Григорьевич", sdf.parse("08.10.1957"), "Мужчина");
//            Person mother = new Person("Валентина", "Андреева", "Павловна", sdf.parse("15.03.1957"), "Женщина");
//            Person child1 = new Person("Сергей", "Андреев", "Анатольевич", sdf.parse("11.03.1990"), "Мужчина");
//            Person child2 = new Person("Денис", "Андреев", "Анатольевич", sdf.parse("14.01.1982"), "Мужчина");
//            Person child3 = new Person("Алексей", "Андреев", "Анатольевич", sdf.parse("17.04.1984"), "Мужчина");
//
//            // Добавляем членов семьи в дерево
//            familyTree.addMember(father);
//            familyTree.addMember(mother);
//            familyTree.addMember(child1);
//            familyTree.addMember(child2);
//            familyTree.addMember(child3);
//
//            // Сортировка по имени
//            System.out.println("Сортировка по имени:");
//            familyTree.sortByName();
//            familyTree.getMembers().forEach(System.out::println);
//
//            // Сортировка по дате рождения
//            System.out.println("\nСортировка по дате рождения:");
//            familyTree.sortByBirthDate();
//            familyTree.
//                    getMembers().
//                    forEach(System.out::println);
//
//            // Пример сохранения в файл
//            FileHandler fileHandler = new FileHandler();
//            fileHandler.saveFamilyTree(familyTree, "familyTree.dat");
//
//            // Пример загрузки из файла
//            FamilyTree<?> loadedTree = fileHandler.loadFamilyTree("familyTree.dat");
//            System.out.println("Дерево семьи загружено из файла.");
//            if (loadedTree != null) {
//                loadedTree.getMembers().forEach(System.out::println);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        ConsoleUi consoleUi = new ConsoleUi();
//        consoleUi.start();
//    }
        ConsoleUi consoleUi = new ConsoleUi();
        consoleUi.start();
    }
}

