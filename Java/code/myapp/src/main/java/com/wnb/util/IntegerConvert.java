package com.wnb.util;

import java.math.BigInteger;
import java.util.Set;

import com.google.common.collect.Sets;
import com.google.common.primitives.Chars;

public class IntegerConvert {
    private static BigInteger ZERO = BigInteger.ZERO;

    private final char[] valueSpace;
    private Set<Character> valueSpaceSet;
    private final int length;

    private IntegerConvert(char[] valueSpace) {
        valueSpaceSet = Sets.newHashSet(Chars.asList(valueSpace));
        if (valueSpaceSet.size() != valueSpace.length) {
            throw new IllegalArgumentException();
        }
        this.valueSpace = valueSpace;
        this.length = valueSpace.length;
    }

    public static IntegerConvert create(char[] valueSpace) {
        return new IntegerConvert(valueSpace);
    }

    public static IntegerConvert create(CharSequence charSequence) {
        char[] chars = new char[charSequence.length()];
        for (int i = 0; i < charSequence.length(); i++) {
            chars[i] = charSequence.charAt(i);
        }
        return new IntegerConvert(chars);
    }

    public String fromBigInteger(BigInteger bigInteger) {
        if (bigInteger == null) {
            throw new IllegalArgumentException();
        }
        if (bigInteger.compareTo(ZERO) < 0) {
            throw new IllegalArgumentException();
        }
        if (bigInteger.compareTo(ZERO) == 0) {
            return Character.valueOf(valueSpace[0]).toString();
        }
        BigInteger i = bigInteger;
        StringBuilder accum = new StringBuilder();
        while (i.compareTo(ZERO) > 0) {
            BigInteger[] bs = i.divideAndRemainder(of(length));
            accum.append(valueSpace[bs[1].intValue()]);
            i = bs[0];
        }
        return accum.reverse().toString();
    }

    public String fromInt(int intValue) {
        return fromBigInteger(of(intValue));
    }

    public String fromLong(long longValue) {
        return fromBigInteger(of(longValue));
    }

    public BigInteger toBigInteger(String stringValue) {
        char[] stringValueChars = stringValue.toCharArray();
        if (!valueSpaceSet.containsAll(Chars.asList(stringValueChars))) {
            throw new IllegalArgumentException();
        }
        BigInteger sum = ZERO;
        int stringValueLength = stringValue.length();
        for (int i = stringValueLength; i > 0; i--) {
            char charValue = stringValue.charAt(stringValueLength - i);
            sum = sum.add(
                    of(length)
                            .pow(i - 1)
                            .multiply(of(indexOf(charValue))));
        }
        return sum;
    }

    public int toInt(String stringValue) {
        return toBigInteger(stringValue).intValue();
    }

    public long toLong(String stringValue) {
        return toBigInteger(stringValue).longValue();
    }

    private BigInteger of(long val) {
        return BigInteger.valueOf(val);
    }

    private int indexOf(char c) {
        for (int i = 0; i < length; i++) {
            if (valueSpace[i] == c) {
                return i;
            }
        }
        return -1;
    }
}
