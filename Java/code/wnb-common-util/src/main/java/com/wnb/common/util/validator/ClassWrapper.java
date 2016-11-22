package com.wnb.common.util.validator;

import static com.wnb.common.util.validator.Validators.is;
import static com.wnb.common.util.validator.BooleanConverter.bool;

public class ClassWrapper<T> {
    private Class<T> clazz;

    ClassWrapper(Class<T> clazz) {
        this.clazz = clazz;
    }

    public boolean hasMethod(String methodName, Class<?>... parameterTypes) {
        if (!bool(methodName)) {
            return false;
        }
        try {
            clazz.getMethod(methodName, parameterTypes);
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    public boolean hasField(String fieldName) {
        if(!bool(fieldName)){
            return false;
        }
        try {
            clazz.getField(fieldName);
            return true;
        } catch (NoSuchFieldException e) {
            return false;
        }
    }
}
