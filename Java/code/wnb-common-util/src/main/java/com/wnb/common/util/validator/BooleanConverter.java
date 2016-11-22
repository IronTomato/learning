package com.wnb.common.util.validator;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class BooleanConverter {

    public static boolean notNull(Object object) {
        return object != null;
    }

    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean not(boolean value) {
        return !value;
    }

    public static boolean bool(boolean value) {
        return value;
    }

    public static boolean bool(int value) {
        return value != 0;
    }

    public static boolean bool(long value) {
        return value != 0L;
    }

    public static boolean bool(short value) {
        return value != 0;
    }

    public static boolean bool(byte value) {
        return value != 0;
    }

    public static boolean bool(float value) {
        return value != 0.0f && !Float.isNaN(value);
    }

    public static boolean bool(double value) {
        return value != 0.0 && !Double.isNaN(value);
    }

    public static boolean bool(char value) {
        return Character.isDefined(value);
    }

    public static boolean bool(Boolean value) {
        return notNull(value) && value.booleanValue();
    }

    public static boolean bool(Integer value) {
        return notNull(value) && bool(value.intValue());
    }

    public static boolean bool(Long value) {
        return notNull(value) && bool(value.longValue());
    }

    public static boolean bool(Short value) {
        return notNull(value) && bool(value.shortValue());
    }

    public static boolean bool(Byte value) {
        return notNull(value) && bool(value.byteValue());
    }

    public static boolean bool(Float value) {
        return notNull(value) && bool(value.floatValue());
    }

    public static boolean bool(Double value) {
        return notNull(value) && bool(value.doubleValue());
    }

    public static boolean bool(Character value) {
        return notNull(value) && bool(value.charValue());
    }

    public static boolean bool(BigInteger value) {
        return notNull(value) && !BigInteger.ZERO.equals(value);
    }

    public static boolean bool(BigDecimal value) {
        return notNull(value) && !BigDecimal.ZERO.equals(value);
    }

    public static boolean bool(CharSequence value) {
        return notNull(value) && value.length() > 0;
    }

    public static <E> boolean bool(Collection<E> value) {
        return notNull(value) && value.size() > 0;
    }

    public static <K, V> boolean bool(Map<K, V> value) {
        return notNull(value) && value.size() > 0;
    }

    public static <E> boolean bool(Iterator<E> value) {
        return notNull(value) && value.hasNext();
    }

    public static <T> boolean bool(Iterable<T> value) {
        return notNull(value) && bool(value.iterator());
    }

    public static boolean bool(BooleanConvertable value) {
        return notNull(value) && value.toBoolean();
    }

    public static boolean bool(boolean[] value) {
        return notNull(value) && value.length > 0;
    }

    public static boolean bool(int[] value) {
        return notNull(value) && value.length > 0;
    }

    public static boolean bool(long[] value) {
        return notNull(value) && value.length > 0;
    }

    public static boolean bool(short[] value) {
        return notNull(value) && value.length > 0;
    }

    public static boolean bool(byte[] value) {
        return notNull(value) && value.length > 0;
    }

    public static boolean bool(float[] value) {
        return notNull(value) && value.length > 0;
    }

    public static boolean bool(double[] value) {
        return notNull(value) && value.length > 0;
    }

    public static boolean bool(char[] value) {
        return notNull(value) && value.length > 0;
    }

    public static <T> boolean bool(T[] value) {
        return notNull(value) && value.length > 0;
    }

    public static <T> boolean bool(T value) {
        return notNull(value);
    }

    public static <T> boolean bool(T value, Predicate<T> predicate) {
        return notNull(value) && predicate.test(value);
    }

    public static boolean bool(File value) {
        return notNull(value) && value.exists();
    }

    public static boolean bool(Thread value) {
        return notNull(value) && value.isAlive();
    }

    public static boolean bool(Date value) {
        return notNull(value) && bool(value.getTime());
    }

    public static boolean bool(Socket value) {
        return notNull(value) && value.isConnected() && !value.isClosed();
    }

    public static boolean bool(Connection value) {
        try {
            return notNull(value) && !value.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean all(boolean... values) {
        if (bool(values)) {
            for (boolean value : values) {
                if (!value) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }


    public static boolean any(boolean... values) {
        if (bool(values)) {
            for (boolean value : values) {
                if (value) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }
}
