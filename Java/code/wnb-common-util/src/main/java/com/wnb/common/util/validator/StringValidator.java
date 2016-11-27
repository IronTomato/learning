package com.wnb.common.util.validator;

import java.util.regex.Pattern;


public interface StringValidator extends CharSequenceValidator<String>,ComparableValidator<String> {
    boolean contains(CharSequence subSequence);

    boolean contains(Pattern pattern);

    boolean containsPattern(String regex);

    boolean in(String s);

    boolean endsWith(String suffix);

    boolean startsWith(String prefix);

    boolean matches(String regex);

    boolean matches(Pattern pattern);

    boolean equalsIgnoreCase(String anotherString);
}
