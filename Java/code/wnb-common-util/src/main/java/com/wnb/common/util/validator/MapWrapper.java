package com.wnb.common.util.validator;

import java.util.Map;
import static com.wnb.common.util.validator.BooleanConverter.*;

public class MapWrapper<K,V> {
    private Map<K,V> map;

    MapWrapper(Map<K, V> map) {
        this.map = map;
    }

    public boolean containsKey(K key) {
        return bool(map) && map.containsKey(key);
    }

    public boolean containsValue(V value) {
        return bool(map) && map.containsValue(value);
    }

    public boolean notEmpty(){
        return bool(map);
    }

    public boolean empty(){
        return !bool(map);
    }
}
