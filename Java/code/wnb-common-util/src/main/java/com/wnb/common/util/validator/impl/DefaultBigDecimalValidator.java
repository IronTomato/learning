package com.wnb.common.util.validator.impl;

import com.wnb.common.util.validator.BigDecimalValidator;

import java.math.BigDecimal;

public class DefaultBigDecimalValidator extends DefaultComparableValidator<BigDecimal>
        implements BigDecimalValidator {
    public DefaultBigDecimalValidator(BigDecimal decimal) {
        super(decimal);
    }

    @Override
    public boolean positive() {
        return gt(BigDecimal.ZERO);
    }

    @Override
    public boolean negative() {
        return lt(BigDecimal.ZERO);
    }

    @Override
    public boolean zero() {
        return eq(BigDecimal.ZERO);
    }
}
