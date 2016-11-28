package com.wnb.common.util;

public class ArrayBoxing {
    public static Integer[] box(int[] ints) {
        if (ints == null) {
            return null;
        }
        Integer[] result = new Integer[ints.length];
        for (int i = 0; i < ints.length; i++) {
            result[i] = ints[i];
        }
        return result;
    }

    public static Long[] box(long[] longs) {
        if (longs == null) {
            return null;
        }
        Long[] result = new Long[longs.length];
        for (int i = 0; i < longs.length; i++) {
            result[i] = longs[i];
        }
        return result;
    }

    public static Short[] box(short[] shorts) {
        if (shorts == null) {
            return null;
        }
        Short[] result = new Short[shorts.length];
        for (int i = 0; i < shorts.length; i++) {
            result[i] = shorts[i];
        }
        return result;
    }

    public static Byte[] box(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        Byte[] result = new Byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            result[i] = bytes[i];
        }
        return result;
    }

    public static Float[] box(float[] floats) {
        if (floats == null) {
            return null;
        }
        Float[] result = new Float[floats.length];
        for (int i = 0; i < floats.length; i++) {
            result[i] = floats[i];
        }
        return result;
    }

    public static Double[] box(double[] doubles) {
        if (doubles == null) {
            return null;
        }
        Double[] result = new Double[doubles.length];
        for (int i = 0; i < doubles.length; i++) {
            result[i] = doubles[i];
        }
        return result;
    }

    public static Boolean[] box(boolean[] booleans) {
        if (booleans == null) {
            return null;
        }
        Boolean[] result = new Boolean[booleans.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = booleans[i];
        }
        return result;
    }

    public static Character[] box(char[] chars) {
        if (chars == null) {
            return null;
        }
        Character[] result = new Character[chars.length];
        for (int i = 0; i < chars.length; i++) {
            result[i] = chars[i];
        }
        return result;
    }
}
