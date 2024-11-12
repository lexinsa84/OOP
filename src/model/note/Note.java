package model.note;

import model.note.NoteInterface;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Note implements NoteInterface, Serializable {
    private static final long serialVersionUID = 2L;
    private LocalDateTime dateTime;
    private String description;

    public Note(LocalDateTime dateTime, String description) {
        this.dateTime = dateTime;
        this.description = description;
    }

    @Override
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return dateTime + " - " + description;
    }
}
