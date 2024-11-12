package model.notebook;

import model.fileWork.FileManager;
import model.note.Note;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Notebook implements NotebookInterface, Serializable {
    private static final long serialVersionUID = 2L;
    private List<Note> notes = new ArrayList<>();

    @Override
    public void addNote(Note note) {
        notes.add(note);
    }

    @Override
    public List<Note> getNotes() {
        return new ArrayList<>(notes);
    }

    @Override
    public List<Note> findNoteByDate(LocalDate date) {
        return notes.stream()
                .filter(e -> e.getDateTime().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Note> findNoteByWeek(LocalDate startOfWeek) {
        LocalDate endOfWeek = startOfWeek.plusDays(6);
        return notes.stream()
                .filter(e -> {
                    LocalDate noteDate = e.getDateTime().toLocalDate();
                    return (noteDate.isEqual(startOfWeek) || noteDate.isAfter(startOfWeek)) &&
                            (noteDate.isEqual(endOfWeek) || noteDate.isBefore(endOfWeek));
                })
                .collect(Collectors.toList());
    }

    @Override
    public void saveToFile(String filename) {
        FileManager.saveNotesToFile(notes, filename);
    }

    @Override
    public void loadFromFile(String filename) {
        notes = FileManager.loadNotesFromFile(filename);
    }
}

