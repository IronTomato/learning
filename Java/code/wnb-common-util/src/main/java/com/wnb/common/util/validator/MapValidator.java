package com.wnb.common.util.validator;

import java.util.Map;

public class MapValidator<M extends Map<K, V>, K, V> extends GenericValidator<M> {


    public  MapValidator(M value) {
        super(value);
    }

    public boolean containsKey(K key) {
        return notNull() && value.containsKey(key);
    }

    public boolean empty() {
        return isNull() || value.isEmpty();
    }

    public boolean notEmpty() {
        return !empty();
    }
}
