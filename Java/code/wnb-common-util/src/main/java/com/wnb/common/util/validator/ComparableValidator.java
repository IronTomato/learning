package com.wnb.common.util.validator;

public interface ComparableValidator<T extends Comparable<T>> extends GenericValidator<T> {

    boolean gt(T other);

    boolean lt(T other);

    boolean gte(T other);

    boolean lte(T other);

    boolean eq(T other);
}
