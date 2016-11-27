package com.wnb.common.util.validator;

import java.util.Collection;

public interface CollectionValidator<C extends Collection<E>,E> extends IterableValidator<C,E>{
    boolean contains(E element);
}
