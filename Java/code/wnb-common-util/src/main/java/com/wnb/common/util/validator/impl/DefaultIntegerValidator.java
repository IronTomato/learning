package com.wnb.common.util.validator.impl;

import com.wnb.common.util.validator.IntegerValidator;

public class DefaultIntegerValidator extends DefaultComparableValidator<Integer>
        implements IntegerValidator {
    public DefaultIntegerValidator(Integer integer) {
        super(integer);
    }

    public boolean even() {
        return notNull() && (value & 1) == 0;
    }

    public boolean odd() {
        return notNull() && (value & 1) == 1;
    }

    @Override
    public boolean positive() {
        return gt(0);
    }

    @Override
    public boolean negative() {
        return lt(0);
    }

    @Override
    public boolean zero() {
        return eq(0);
    }
}
