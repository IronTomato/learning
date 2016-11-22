package com.wnb.common.util.validator;

import java.util.Iterator;

public class IterableValidator<I extends Iterable<E>, E> extends GenericValidator<I> {
    public IterableValidator(I iterable) {
        super(iterable);
    }

    public boolean empty() {
        if (isNull()) {
            return true;
        }
        Iterator<E> iter = value.iterator();
        return iter == null || !iter.hasNext();
    }

    public boolean notEmpty() {
        return !empty();
    }

    public boolean allSuit(Predicate<E> predicate) {
        if (isNull() || predicate == null) {
            return false;
        }
        for (E e : value) {
            if (!predicate.test(e)) {
                return false;
            }
        }
        return true;
    }

    public boolean anySuit(Predicate<E> predicate) {
        if (isNull() || predicate == null) {
            return false;
        }
        for (E e : value) {
            if (predicate.test(e)) {
                return true;
            }
        }
        return false;
    }
}
