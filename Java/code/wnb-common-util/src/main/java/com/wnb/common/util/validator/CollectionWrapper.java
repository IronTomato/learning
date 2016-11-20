package com.wnb.common.util.validator;

import java.util.Collection;

import static com.wnb.common.util.validator.BooleanConverter.*;

public class CollectionWrapper<E> {
    private Collection<E> collection;

    CollectionWrapper(Collection<E> collection){
        this.collection = collection;
    }

    public boolean contains(E element) {
        return bool(collection) && collection.contains(element);
    }

    public boolean notEmpty() {
        return bool(collection);
    }

    public boolean empty() {
        return !bool(collection);
    }
}
