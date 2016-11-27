package com.wnb.common.util.validator;


import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

public interface GenericValidator<T> {


    boolean notNull();

    boolean isNull();

    <C extends Collection<T>> boolean in(C collection);

    <M extends Map<T, V>, V> boolean in(M map);

    boolean in(T[] array);

    boolean ontOf(T... values);

    boolean suit(Predicate<T> predicate);

    boolean eq(T other);

    boolean eq(T other, Comparator<T> comparator);

    boolean gt(T other, Comparator<T> comparator);

    boolean lt(T other, Comparator<T> comparator);

    boolean gte(T other, Comparator<T> comparator);

    boolean lte(T other, Comparator<T> comparator);

}
