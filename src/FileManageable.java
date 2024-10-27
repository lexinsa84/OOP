import java.io.IOException;


public interface FileManageable {
    void writeToFile(String filename, FamilyTree familyTree) throws IOException;
    FamilyTree readFromFile(String filename) throws IOException, ClassNotFoundException;
}
