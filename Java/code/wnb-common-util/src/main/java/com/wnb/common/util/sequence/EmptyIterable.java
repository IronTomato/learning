package com.wnb.common.util.sequence;

import java.util.Iterator;

public class EmptyIterable<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new EmptyIterator<T>();
    }
}
