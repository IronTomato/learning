package com.wnb.common.util.validator;

import java.util.Collection;
import java.util.Map;

import static com.wnb.common.util.validator.BooleanConverter.*;
import static com.wnb.common.util.validator.Wrappers.*;

public class StringWrapper {
    private String str;

    StringWrapper(String str) {
        this.str = str;
    }

    public boolean empty() {
        return !bool(str);
    }

    public boolean notEmpty() {
        return bool(str);
    }

    public boolean blank() {
        return empty() || str.replaceAll("\\s", "").isEmpty();
    }

    public boolean notBlank() {
        return !blank();
    }

    public boolean contains(CharSequence subSequence) {
        return all(notNull(str), notNull(subSequence), str.contains(subSequence));
    }

    public boolean in(Collection<String> collection) {
        return is(collection).contains(str);
    }

    public boolean in(Map<String, ?> map) {
        return is(map).containsKey(str);
    }

    public boolean in(String s) {
        return is(s).contains(str);
    }

    public boolean endsWith(String suffix) {
        return notNull(str) && notNull(suffix) && str.endsWith(suffix);
    }

    public boolean startsWith(String prefix) {
        return notNull(str) && notNull(prefix) && str.startsWith(prefix);
    }

    public boolean matches(String regex) {
        return notNull(str) && notNull(regex) && str.matches(regex);
    }

    public boolean equalsIgnoreCase(String anotherString) {
        return notNull(str) && notNull(anotherString) && str.equalsIgnoreCase(anotherString);
    }


    public boolean canParseInt() {
        if (isNull(str)) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean canParseDouble() {
        if (isNull(str)) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
