package model.util;

import model.FamilyTree;

import java.util.List;

public interface FileHandlerInterface <T>{


   void saveFile(T data, String filePath);

   T loadFile(String filePath);

}
