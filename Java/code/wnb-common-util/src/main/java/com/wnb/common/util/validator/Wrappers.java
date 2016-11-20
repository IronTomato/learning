package com.wnb.common.util.validator;

import java.util.Collection;
import java.util.Map;

public class Wrappers {
    public static <E> CollectionWrapper<E> is(Collection<E> collection){
        return new CollectionWrapper<E>(collection);
    }

    public static <K, V> MapWrapper<K, V> is(Map<K, V> map) {
        return new MapWrapper<K, V>(map);
    }

    public static StringWrapper is(String str){
        return new StringWrapper(str);
    }

    public static <T> GenericWrapper<T> is(T obj) {
        return new GenericWrapper<T>(obj);
    }

    public static <T> ClassWrapper<T> is(Class<T> clazz){
        return new ClassWrapper(clazz);
    }
}
