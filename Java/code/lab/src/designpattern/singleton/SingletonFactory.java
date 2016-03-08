package designpattern.singleton;

import java.util.HashMap;
import java.util.Map;

public class SingletonFactory {
    private static Map<Class<?>, Object> register = new HashMap<>();

    private SingletonFactory() {
    }

    public static Object getSingleton(Class<?> clazz) {
        if (register.containsKey(clazz)) {
            return register.get(clazz);
        }
        synchronized (register) {
            if (!register.containsKey(clazz)) {
                try {
                    Object instance = clazz.newInstance();
                    register.put(clazz, instance);
                } catch (InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(clazz.getName() + " 获取实例失败", e);
                }
            }
            return register.get(clazz);
        }

    }
}
