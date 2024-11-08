package model.Person.comparators;

import model.Person.FamilyMember;
import java.util.Comparator;

public class ComparatorByBirth<E extends FamilyMember> implements Comparator<E> {
    @Override
    public int compare(E a, E b) {
        return Integer.compare(b.getBirthDate().getYear(), a.getBirthDate().getYear());
    }
}
