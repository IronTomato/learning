package com.wnb.common.util.validator.impl;

import com.wnb.common.util.validator.ComparableValidator;
import com.wnb.common.util.validator.GenericValidator;

public class DefaultComparableValidator<T extends Comparable<T>> extends DefaultGenericValidator<T>
        implements ComparableValidator<T>, GenericValidator<T> {
    public DefaultComparableValidator(T comparable) {
        super(comparable);
    }

    public boolean gt(T other) {
        return notNull() && other != null && value.compareTo(other) > 0;
    }

    public boolean lt(T other) {
        return notNull() && other != null && value.compareTo(other) < 0;
    }

    public boolean gte(T other) {
        return gt(other) || eq(other);
    }

    public boolean lte(T other) {
        return lt(other) || eq(other);
    }

    @Override
    public boolean eq(T other) {
        return notNull() && other != null && value.compareTo(other) == 0;
    }
}
