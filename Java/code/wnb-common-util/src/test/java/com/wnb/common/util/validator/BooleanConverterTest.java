package com.wnb.common.util.validator;

import static org.junit.Assert.*;

import com.wnb.common.util.validator.Predicate;
import org.junit.Test;

import static com.wnb.common.util.validator.BooleanConverter.*;

/**
 * Created by 乃镔 on 2016/11/20.
 */
public class BooleanConverterTest {

    @Test
    public void testBoolean() {
        boolean a = true;
        boolean b = false;
        all(a, b);
    }

    @Test
    public void testPredicate() {
        ClassA a = new ClassA();
        a.x = 0;
        a.y = 0;
        Predicate<ClassA> aPredicate = new Predicate<ClassA>() {
            @Override
            public boolean test(ClassA value) {
                return all(bool(value.x), bool(value.y));
            }
        };
        assertTrue(bool(a));
        assertFalse(bool(a, aPredicate));
    }

    private static class ClassA {
        int x, y;
    }

    @Test
    public void testIntegerPredicate() {
        Predicate<Integer> integerPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer value) {
                return true;
            }
        };
        assertTrue(notNull(Integer.valueOf(0)));
    }
}
