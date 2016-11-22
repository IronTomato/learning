package com.wnb.common.util.validator;

public class IntegerValidator extends NumberValidator<Integer> {
    IntegerValidator(Integer integer) {
        super(integer);
    }

    public boolean even(){
        return notNull() && (value & 1) == 0;
    }

    public boolean odd(){
        return notNull() && (value & 1) == 1;
    }
}
