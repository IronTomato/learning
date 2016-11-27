package com.wnb.common.util.validator;

public interface NumberValidator<N extends Number> extends GenericValidator<N> {
    boolean positive();

    boolean negative();

    boolean zero();
}
