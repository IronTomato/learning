package com.wnb.common.util.validator;

import com.wnb.common.util.validator.impl.*;

import java.util.Collection;
import java.util.Map;

public class Validators {
    public static <T> GenericValidator<T> is(T obj) {
        return new DefaultGenericValidator<T>(obj);
    }

    public static <I extends Iterable<E>, E> IterableValidator<I, E> is(I iterable) {
        return new DefaultIterableValidator<I, E>(iterable);
    }

    public static <C extends Collection<E>, E> CollectionValidator<C, E> is(C collection) {
        return new DefaultCollectionValidator<C, E>(collection);
    }

    public static <M extends Map<K, V>, K, V> MapValidator<M, K, V> is(M map) {
        return new DefaultMapValidator<M, K, V>(map);
    }

    public static <T> ArrayValidator<T> is(T[] array) {
        return new DefaultArrayValidator<T>(array);
    }

    public static <T extends Comparable<T>> ComparableValidator<T> is(T comparable) {
        return new DefaultComparableValidator<T>(comparable);
    }

    public static <N extends Number> NumberValidator<N> is(N number) {
        return new DefaultNumberValidator<N>(number);
    }

    public static IntegerValidator is(Integer integer) {
        return new DefaultIntegerValidator(integer);
    }

    public static DoubleValidator is(Double doubleValue){
        return new DefaultDoubleValidator(doubleValue);
    }

    public static <S extends CharSequence> CharSequenceValidator<S> is(S charSequence) {
        return new DefaultCharSequenceValidator<S>(charSequence);
    }

    public static StringValidator is(String str) {
        return new DefaultStringValidator(str);
    }


}
