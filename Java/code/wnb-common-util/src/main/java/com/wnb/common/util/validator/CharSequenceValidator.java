package com.wnb.common.util.validator;

public class CharSequenceValidator<S extends CharSequence> extends GenericValidator<S> {
    public CharSequenceValidator(S sequence) {
        super(sequence);
    }

    public boolean empty() {
        return isNull() || value.length() == 0;
    }

    public boolean notEmpty() {
        return !empty();
    }
}
