package view;

import model.note.Note;

import java.util.List;

public class ConsoleNotebookView implements NotebookView {
    @Override
    public void displayNotes(List<Note> notes) {
        if (notes.isEmpty()) {
            System.out.println("Записей не найдено.");
        } else {
            notes.forEach(note -> System.out.println(note));
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayError(String errorMessage) {
        System.err.println("Ошибка: " + errorMessage);
    }
}

