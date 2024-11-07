package model;

import model.iterators.FamilyFreeIterator;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends Person> implements Serializable, Iterable<T> {
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
        Collections.sort(members, Comparator
                .comparing(T::getFirstName)
                .thenComparing(T::getLastName)
                .thenComparing(T::getPatronymic));

    }

    public void sortByBirthDate() {
        Collections.sort(members, Comparator.comparing(T::getBirthDate));

    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyFreeIterator<T>(members);
    }
}

