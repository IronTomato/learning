package com.wnb.common.util.validator;

public interface IntegerValidator extends NumberValidator<Integer>,ComparableValidator<Integer> {

    boolean even();

    boolean odd();
}
