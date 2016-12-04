package com.wnb.common.util.validator;

import com.wnb.common.util.ArrayBoxing;
import com.wnb.common.util.validator.impl.*;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
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

    public static ArrayValidator<Integer> is(int[] ints) {
        return new DefaultArrayValidator<Integer>(ArrayBoxing.box(ints));
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

    public static DoubleValidator is(Double doubleValue) {
        return new DefaultDoubleValidator(doubleValue);
    }

    public static BigDecimalValidator is(BigDecimal decimal) {
        return new DefaultBigDecimalValidator(decimal);
    }

    public static <S extends CharSequence> CharSequenceValidator<S> is(S charSequence) {
        return new DefaultCharSequenceValidator<S>(charSequence);
    }

    public static StringValidator is(String str) {
        return new DefaultStringValidator(str);
    }

    public static <F extends File> FileValidator<F> is(F file) {
        return new DefaultFileValidator<F>(file);
    }

    private static <T, R1 extends GenericValidator<T>, R2 extends R1> R1 allSuitProxy(final Iterable<T> iterable, final Class<R1> clazz1, final Class<R2> clazz2) {
        return (R1) Proxy.newProxyInstance(
                Validators.class.getClassLoader(),
                new Class[]{clazz1},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return is(iterable).allSuit(new Predicate<T>() {
                            @Override
                            public boolean test(T value) {
                                try {
                                    return (boolean) method.invoke(clazz2.getConstructor(value.getClass()).newInstance(value), args);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                return false;
                            }
                        });
                    }
                });
    }

    private static <T, R1 extends GenericValidator<T>, R2 extends R1> R1 anySuitProxy(final Iterable<T> iterable, final Class<R1> clazz1, final Class<R2> clazz2) {
        return (R1) Proxy.newProxyInstance(
                Validators.class.getClassLoader(),
                new Class[]{clazz1},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return is(iterable).anySuit(new Predicate<T>() {
                            @Override
                            public boolean test(T value) {
                                try {
                                    return (boolean) method.invoke(clazz2.getConstructor(value.getClass()).newInstance(value), args);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                return false;
                            }
                        });
                    }
                });
    }

    public static <T> GenericValidator<T> isAll(Iterable<T> iter, T... ignore) {
        return allSuitProxy(iter, GenericValidator.class, DefaultGenericValidator.class);
    }

    public static <I extends Iterable<E>, E> IterableValidator<I, E> isAll(Iterable<I> iter, I... ignore) {
        return allSuitProxy(iter, IterableValidator.class, DefaultIterableValidator.class);
    }

    public static <C extends Collection<E>, E> CollectionValidator<C, E> isAll(Iterable<C> iter, C... ignore) {
        return allSuitProxy(iter, CollectionValidator.class, DefaultCollectionValidator.class);
    }


    public static <M extends Map<K, V>, K, V> MapValidator<M, K, V> isAll(Iterable<M> iter, M... ignore) {
        return allSuitProxy(iter, MapValidator.class, DefaultMapValidator.class);
    }

    public static <T> ArrayValidator<T> isAll(Iterable<T[]> iter, T[]... ignore) {
        return allSuitProxy(iter, ArrayValidator.class, DefaultArrayValidator.class);
    }

    public static <T extends Comparable<T>> ComparableValidator<T> isAll(Iterable<T> iter, T... ignore) {
        return allSuitProxy(iter, ComparableValidator.class, DefaultComparableValidator.class);
    }

    public static <N extends Number> NumberValidator<N> isAll(Iterable<N> iter, N... ignore) {
        return allSuitProxy(iter, NumberValidator.class, DefaultNumberValidator.class);
    }

    public static IntegerValidator isAll(Iterable<Integer> iter, Integer... ignore) {
        return allSuitProxy(iter, IntegerValidator.class, DefaultIntegerValidator.class);
    }

    public static DoubleValidator isAll(Iterable<Double> iter, Double... ignore) {
        return allSuitProxy(iter, DoubleValidator.class, DefaultDoubleValidator.class);
    }

    public static BigDecimalValidator isAll(Iterable<BigDecimal> iter, BigDecimal... ignore) {
        return allSuitProxy(iter, BigDecimalValidator.class, DefaultBigDecimalValidator.class);
    }

    public static <S extends CharSequence> CharSequenceValidator<S> isAll(Iterable<S> iter, S... ignore) {
        return allSuitProxy(iter, CharSequenceValidator.class, DefaultCharSequenceValidator.class);
    }

    public static StringValidator isAll(Iterable<String> iter, String... ignore) {
        return allSuitProxy(iter, StringValidator.class, DefaultStringValidator.class);
    }


}
