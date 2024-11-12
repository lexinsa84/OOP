package presenter;

import model.note.Note;
import model.notebook.Notebook;
import view.NotebookView;
import view.View;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NotebookPresenter{
//    private final Notebook notebook;
    private final NotebookView view;
    private final Notebook notebook;

    public NotebookPresenter(View view) {

        this.view = (NotebookView) view;
        notebook = new Notebook();
    }

    public void addNote(LocalDateTime dateTime, String description) {
        Note note = new Note(dateTime, description);
        notebook.addNote(note);
        view.displayMessage("Запись добавлена.");
    }

    public void showNotesForDate(LocalDate date) {
        view.displayNotes(notebook.findNoteByDate(date));
    }

    public void showNotesForWeek(LocalDate startOfWeek,LocalDate endOfWeek) {
        view.displayNotes(notebook.findNoteByWeek(startOfWeek));
    }

    public void saveNote(String filename) {
        notebook.saveToFile(filename);
        view.displayMessage("Записи сохранены в файл.");
    }

    public void loadNote(String filename) {
        notebook.loadFromFile(filename);
        view.displayMessage("Записи загружены из файла.");
    }
}

