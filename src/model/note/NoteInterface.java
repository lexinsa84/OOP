package model.note;

import java.time.LocalDateTime;

public interface NoteInterface {
    LocalDateTime getDateTime();
    String getDescription();
    void setDateTime(LocalDateTime dateTime);
    void setDescription(String description);
}
