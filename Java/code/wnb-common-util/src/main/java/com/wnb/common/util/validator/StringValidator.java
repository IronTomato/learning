package com.wnb.common.util.validator;

import static com.wnb.common.util.validator.Validators.*;

public class StringValidator extends CharSequenceValidator<String> {


    public StringValidator(String sequence) {
        super(sequence);
    }

    public boolean blank() {
        return empty() || value.matches("^\\s*$");
    }

    public boolean notBlank() {
        return !blank();
    }

    public boolean contains(CharSequence subSequence) {
        return notNull() && subSequence != null && value.contains(subSequence);
    }

    public boolean in(String s) {
        return is(s).contains(value);
    }

    public boolean endsWith(String suffix) {
        return notNull() && suffix != null && value.endsWith(suffix);
    }

    public boolean startsWith(String prefix) {
        return notNull() && prefix != null && value.startsWith(prefix);
    }

    public boolean matches(String regex) {
        return notNull() && regex != null && value.matches(regex);
    }

    public boolean equalsIgnoreCase(String anotherString) {
        return notNull() && anotherString != null && value.equalsIgnoreCase(anotherString);
    }


    public boolean canParseInt() {
        if (isNull()) {
            return false;
        }
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean canParseDouble() {
        if (isNull()) {
            return false;
        }
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
