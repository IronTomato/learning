package com.wnb.common.util.validator;

import java.util.Collection;


public class CollectionValidator<T extends Collection<E>,E> extends GenericValidator<T>{


    CollectionValidator(T collection) {
        super(collection);
    }

    public boolean empty(){
        return isNull() || value.isEmpty();
    }

    public boolean notEmpty(){
        return !empty();
    }

    public boolean contains(E element) {
        return notNull() && value.contains(element);
    }

}
