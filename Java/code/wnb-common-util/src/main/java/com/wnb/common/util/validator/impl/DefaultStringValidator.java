package com.wnb.common.util.validator.impl;

import com.wnb.common.util.validator.CharSequenceValidator;
import com.wnb.common.util.validator.ComparableValidator;
import com.wnb.common.util.validator.StringValidator;

import java.util.regex.Pattern;

import static com.wnb.common.util.validator.Validators.*;

public class DefaultStringValidator extends DefaultCharSequenceValidator<String>
        implements StringValidator, CharSequenceValidator<String>, ComparableValidator<String> {


    public DefaultStringValidator(String sequence) {
        super(sequence);
    }

    public boolean contains(CharSequence subSequence) {
        return notNull() && subSequence != null && value.contains(subSequence);
    }

    public boolean contains(Pattern pattern) {
        return notNull() && pattern != null && pattern.matcher(value).find();
    }

    public boolean containsPattern(String regex) {
        return notNull() && regex != null && Pattern.compile(regex).matcher(value).find();
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

    public boolean matches(Pattern pattern) {
        return notNull() && pattern.matcher(value).matches();
    }

    public boolean equalsIgnoreCase(String anotherString) {
        return notNull() && anotherString != null && value.equalsIgnoreCase(anotherString);
    }

    @Override
    public boolean gt(String other) {
        return is((Comparable) value).gt(other);
    }

    @Override
    public boolean lt(String other) {
        return is((Comparable) value).lt(other);
    }

    @Override
    public boolean gte(String other) {
        return is((Comparable) value).gte(other);
    }

    @Override
    public boolean lte(String other) {
        return is((Comparable) value).lte(other);
    }

    @Override
    public boolean eq(String other) {
        return is((Comparable) value).eq(other);
    }
}
