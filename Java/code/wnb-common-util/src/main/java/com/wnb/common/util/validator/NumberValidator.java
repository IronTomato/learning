package com.wnb.common.util.validator;

public class NumberValidator<N extends Number> extends GenericValidator<N> {
    NumberValidator(N number) {
        super(number);
    }

    public boolean positive(){
        return notNull() && value.doubleValue() > 0.0;
    }

    public boolean negative(){
        return notNull() && value.doubleValue() < 0.0;
    }

    public boolean zero(){
        return notNull() && value.doubleValue() == 0.0;
    }
}
