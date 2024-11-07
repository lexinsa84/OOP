package model.util;

import model.FamilyTree;

import java.io.*;

public class FileHandler implements FileHandlerInterface <FamilyTree<?>> {

//    public void saveFile(FamilyTree<?> familyTree, String filePath) {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
//            oos.writeObject(familyTree);
//            System.out.println("Дерево семьи успешно сохранено в файл: " + filePath);
//        } catch (IOException e) {
//            System.out.println("Ошибка при сохранении дерева в файл: " + e.getMessage());
//        }
//    }

//    public FamilyTree<?> loadFile(String filePath) {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
//            return (FamilyTree<?>) ois.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("Ошибка при загрузке дерева из файла: " + e.getMessage());
//            return null;
//        }
//    }

    @Override
    public void saveFile(FamilyTree<?> familyTree, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(familyTree);
            System.out.println("Дерево семьи успешно сохранено в файл: " + filePath);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении дерева в файл: " + e.getMessage());
        }
    }

    @Override
    public FamilyTree<?> loadFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (FamilyTree<?>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке дерева из файла: " + e.getMessage());
            return null;
        }
    }
}



