package com.wnb.common.util.validator.impl;

import com.wnb.common.util.validator.DoubleValidator;

public class DefaultDoubleValidator extends DefaultComparableValidator<Double>
        implements DoubleValidator {
    public DefaultDoubleValidator(Double doubleValue) {
        super(doubleValue);
    }

    @Override
    public boolean positive() {
        return gt(0.0);
    }

    @Override
    public boolean negative() {
        return lt(0.0);
    }

    @Override
    public boolean zero() {
        return eq(0.0);
    }
}
