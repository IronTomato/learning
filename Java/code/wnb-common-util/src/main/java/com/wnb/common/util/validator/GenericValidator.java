package com.wnb.common.util.validator;

import java.util.Collection;
import java.util.Map;

import static com.wnb.common.util.validator.Validators.*;

public class GenericValidator<T> {
    protected T value;

    public GenericValidator(T value) {
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

    public boolean in(T[] array){
        return is(array).contains(value);
    }

    public boolean ontOf(T... values){
        return in(values);
    }

    public boolean suit(Predicate<T> predicate) {
        return predicate != null && predicate.test(value);
    }

    public boolean equalTo(T other) {
        return (isNull() && other == null) || (notNull() && value.equals(other));
    }

}
