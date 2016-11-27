package com.wnb.common.util.validator.impl;

import com.wnb.common.util.validator.CharSequenceValidator;
import com.wnb.common.util.validator.GenericValidator;

public class DefaultCharSequenceValidator<S extends CharSequence> extends DefaultGenericValidator<S>
        implements CharSequenceValidator<S>,GenericValidator<S> {
    public DefaultCharSequenceValidator(S sequence) {
        super(sequence);
    }

    public boolean empty() {
        return isNull() || value.length() == 0;
    }

    public boolean notEmpty() {
        return !empty();
    }

    public boolean blank() {
        if (empty()) {
            return true;
        }
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isWhitespace(value.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean notBlank() {
        return !blank();
    }
}
