package com.wnb.common.util.validator;


public interface ArrayValidator<T> extends GenericValidator<T[]> {
    boolean empty();

    boolean notEmpty();

    boolean contains(T element);
}
