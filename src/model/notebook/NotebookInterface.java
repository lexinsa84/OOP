package model.notebook;

import model.note.Note;

import java.time.LocalDate;
import java.util.List;

public interface NotebookInterface {
    void addNote(Note note);
    List<Note> getNotes();
    List<Note> findNoteByDate(LocalDate date);
    List<Note> findNoteByWeek(LocalDate startOfWeek);
    void saveToFile(String filename);
    void loadFromFile(String filename);
}
