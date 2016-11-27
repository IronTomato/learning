package com.wnb.common.util.validator;

import java.util.Map;

public interface MapValidator<M extends Map<K, V>, K, V> extends GenericValidator<M> {

    boolean containsKey(K key);

    boolean empty();

    boolean notEmpty();
}
