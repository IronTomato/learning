package com.wnb.common.util.validator;

import java.util.Collection;


public class CollectionValidator<C extends Collection<E>, E> extends IterableValidator<C, E> {


    public CollectionValidator(C collection) {
        super(collection);
    }

    @Override
    public boolean empty() {
        return isNull() || value.isEmpty();
    }

    public boolean contains(E element) {
        return notNull() && value.contains(element);
    }

}
