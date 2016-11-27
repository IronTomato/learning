package com.wnb.common.util.validator.impl;

import com.wnb.common.util.validator.ArrayValidator;
import com.wnb.common.util.validator.impl.DefaultGenericValidator;

import java.util.Arrays;

import static com.wnb.common.util.validator.Validators.is;

public class DefaultArrayValidator<T> extends DefaultGenericValidator<T[]>
        implements ArrayValidator<T> {
    public DefaultArrayValidator(T[] array) {
        super(array);
    }

    public boolean empty() {
        return isNull() || value.length == 0;
    }

    public boolean notEmpty() {
        return !empty();
    }

    public boolean contains(T element) {
        return notEmpty() && is(Arrays.asList(value)).contains(element);
    }
}
