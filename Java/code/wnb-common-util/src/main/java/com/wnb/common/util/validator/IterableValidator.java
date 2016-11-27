package com.wnb.common.util.validator;


public interface IterableValidator<I extends Iterable<E>,E> extends GenericValidator<I> {
    boolean empty();

    boolean notEmpty();

    boolean allSuit(Predicate<E> predicate);

    boolean anySuit(Predicate<E> predicate);
}
