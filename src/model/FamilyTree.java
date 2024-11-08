package model;

import model.Person.FamilyMember;
import model.Person.comparators.ComparatorByBirth;
import model.Person.comparators.ComparatorByName;
import model.iterators.FamilyFreeIterator;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends FamilyMember> implements Serializable, Iterable<T> {
    private static final long serialVersionUID = 1L;
    private List<T> members;

    public FamilyTree() {
        members = new ArrayList<>();
    }

    public void addMember(T member) {
//        if (!members.contains(member)) {
//            members.add(member);
//        } else {
//            System.out.println("Член семьи уже существует: " + member);
//        }
        members.add(member);
    }

    public List<T> getMembers() {
        return new ArrayList<>(members);
    }

    public void sortByName() {
        members.sort(new ComparatorByName<>());

    }

    public void sortByBirthDate() {
        members.sort(new ComparatorByBirth<>());

    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyFreeIterator<T>(members);
    }
}

