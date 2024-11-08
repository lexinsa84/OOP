package model.Person.comparators;

import model.Person.FamilyMember;

import java.util.Comparator;

public class ComparatorByName<E extends FamilyMember> implements Comparator<E> {

    @Override
    public int compare(E a, E b) {
        return a.getName().compareTo(b.getName());
    }
}
