package com.wnb.common.util.validator.impl;

import com.wnb.common.util.validator.CollectionValidator;

import java.util.Collection;


public class DefaultCollectionValidator<C extends Collection<E>, E> extends DefaultIterableValidator<C, E>
        implements CollectionValidator<C, E> {

    public DefaultCollectionValidator(C collection) {
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
