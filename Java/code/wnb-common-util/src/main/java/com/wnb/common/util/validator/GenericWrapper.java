package com.wnb.common.util.validator;

import java.util.Collection;
import java.util.Map;

import static com.wnb.common.util.validator.BooleanConverter.*;
import static com.wnb.common.util.validator.Wrappers.*;

public class GenericWrapper<T> {
    private T t;

    GenericWrapper(T t) {
        this.t = t;
    }

    public boolean notNull() {
        return t != null;
    }

    public boolean hasMethod(String methodName, Class<?>... parameterTypes) {
        return notNull() && is(t.getClass()).hasMethod(methodName, parameterTypes);
    }

    public boolean hasField(String fieldName) {
        return notNull() && is(t.getClass()).hasField(fieldName);
    }

    public boolean in(Collection<T> collection) {
        return is(collection).contains(t);
    }

    public boolean in(Map<T, ?> map) {
        return is(map).containsKey(t);
    }


}
