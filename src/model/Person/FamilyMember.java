package model.Person;

import java.io.Serializable;
import java.time.LocalDate;

public interface FamilyMember extends Serializable {
    String getName();
    LocalDate getBirthDate();
    String getGender();
}
