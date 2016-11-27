package com.wnb.common.util.validator.impl;


import com.wnb.common.util.validator.NumberValidator;

public class DefaultNumberValidator<N extends Number> extends DefaultGenericValidator<N>
        implements NumberValidator<N>{
    public DefaultNumberValidator(N number) {
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
