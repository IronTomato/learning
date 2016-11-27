package com.wnb.common.util.validator.impl;

import com.wnb.common.util.validator.IterableValidator;
import com.wnb.common.util.validator.Predicate;
import com.wnb.common.util.validator.impl.DefaultGenericValidator;

import java.util.Iterator;

public class DefaultIterableValidator<I extends Iterable<E>, E> extends DefaultGenericValidator<I>
        implements IterableValidator<I, E> {
    public DefaultIterableValidator(I iterable) {
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
