package com.wnb.common.util.validator.impl;

import com.wnb.common.util.validator.MapValidator;
import com.wnb.common.util.validator.impl.DefaultGenericValidator;

import java.util.Map;

public class DefaultMapValidator<M extends Map<K, V>, K, V> extends DefaultGenericValidator<M>
        implements MapValidator<M, K, V> {


    public DefaultMapValidator(M value) {
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
