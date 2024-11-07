package model.iterators;

import java.util.Iterator;
import java.util.List;

public class FamilyFreeIterator<T> implements Iterator<T> {
    private int index;
    private List<T> list;

    public FamilyFreeIterator(List<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T next() {
        return list.get(index++);
    }
}