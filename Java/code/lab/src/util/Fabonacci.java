package util;

import java.util.*;
import java.math.*;

public class Fabonacci {

    private List<BigInteger> seq = new ArrayList<>();

    public Fabonacci() {
        seq.add(BigInteger.ONE);
        seq.add(BigInteger.ONE);
    }

    public BigInteger get_(int index) {
        if (index < 1)
            throw new IllegalArgumentException("index should >= 1");
        while (seq.size() < index) {
            int lastIndex = seq.size() - 1;
            seq.add(seq.get(lastIndex).add(seq.get(lastIndex - 1)));
        }
        return seq.get(index - 1);
    }

    public static BigInteger get(int index) {
        if (index < 1)
            throw new IllegalArgumentException("index should >= 1");
        if (index <= 2)
            return BigInteger.ONE;
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger t;
        for (int i = 2; i < index; i++) {
            t = b;
            b = a.add(b);
            a = t;
        }
        return b;

    }
}
