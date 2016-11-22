package com.wnb.common.util.validator;

import java.util.Arrays;

import static com.wnb.common.util.validator.Validators.is;

public class ArrayValidator<T> extends GenericValidator<T[]> {
    ArrayValidator(T[] array) {
        super(array);
    }

    public boolean empty(){
        return isNull() || value.length == 0;
    }

    public boolean notEmpty(){
        return !empty();
    }

    public boolean contains(T element) {
        return notEmpty() && is(Arrays.asList(value)).contains(element);
    }
}
