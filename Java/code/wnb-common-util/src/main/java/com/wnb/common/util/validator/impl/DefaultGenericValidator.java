package com.wnb.common.util.validator.impl;

import com.wnb.common.util.validator.GenericValidator;
import com.wnb.common.util.validator.Predicate;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import static com.wnb.common.util.validator.Validators.*;

public class DefaultGenericValidator<T> implements GenericValidator<T> {
    protected T value;

    public DefaultGenericValidator(T value) {
        this.value = value;
    }

    public boolean notNull() {
        return value != null;
    }

    public boolean isNull() {
        return value == null;
    }

    public <C extends Collection<T>> boolean in(C collection) {
        return is(collection).contains(value);
    }

    public <M extends Map<T, V>, V> boolean in(M map) {
        return is(map).containsKey(value);
    }

    public boolean in(T[] array) {
        return is(array).contains(value);
    }

    public boolean ontOf(T... values) {
        return in(values);
    }

    public boolean suit(Predicate<T> predicate) {
        return predicate != null && predicate.test(value);
    }

    public boolean eq(T other) {
        return notNull() && value.equals(other);
    }

    public boolean eq(T other, Comparator<T> comparator) {
        return notNull() && other != null && comparator != null && comparator.compare(value, other) == 0;
    }

    public boolean gt(T other, Comparator<T> comparator) {
        return notNull() && other != null && comparator != null && comparator.compare(value, other) > 0;
    }

    public boolean lt(T other, Comparator<T> comparator) {
        return notNull() && other != null && comparator != null && comparator.compare(value, other) < 0;
    }

    public boolean gte(T other, Comparator<T> comparator) {
        return gt(other, comparator) || eq(other, comparator);
    }

    public boolean lte(T other, Comparator<T> comparator) {
        return lt(other, comparator) || eq(other, comparator);
    }

}
