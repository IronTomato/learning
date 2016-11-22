package com.wnb.common.util.validator;

import java.util.Collection;
import java.util.Map;

public class Validators {
    public static <T> GenericValidator<T> is(T obj) {
        return new GenericValidator<T>(obj);
    }

    public static <C extends Collection<E>, E> CollectionValidator<C, E> is(C collection) {
        return new CollectionValidator<C, E>(collection);
    }

    public static <M extends Map<K, V>, K, V> MapValidator<M, K, V> is(M map) {
        return new MapValidator<M, K, V>(map);
    }

    public static <T> ArrayValidator<T> is(T[] array) {
        return new ArrayValidator<T>(array);
    }

    public static <N extends Number> NumberValidator<N> is(N number) {
        return new NumberValidator<N>(number);
    }

    public static IntegerValidator is(Integer integer) {
        return new IntegerValidator(integer);
    }

    public static StringValidator is(String str) {
        return new StringValidator(str);
    }


}
