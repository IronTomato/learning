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

    public boolean contains(CharSequence subSequence) {
        return all(notNull(str), notNull(subSequence), str.contains(subSequence));
    }

    public boolean in(Collection<String> collection) {
        return is(collection).contains(str);
    }

    public boolean in(Map<String, ?> map) {
        return is(map).containsKey(str);
    }

}
