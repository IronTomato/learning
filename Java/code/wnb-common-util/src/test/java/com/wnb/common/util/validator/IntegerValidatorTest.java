package com.wnb.common.util.validator;

import com.wnb.common.util.validator.impl.DefaultIntegerValidator;
import org.junit.Test;

import static com.wnb.common.util.validator.Validators.is;
import static org.junit.Assert.*;

public class IntegerValidatorTest {

    @Test
    public void testInstance() {
        assertTrue(is(1) instanceof IntegerValidator);
    }

    @Test
    public void testPositive() {
        assertTrue(is(1).positive());
        assertFalse((is(0)).positive());
        assertFalse((is(-1).positive()));
        assertTrue(is(Integer.valueOf("1")).positive());
        assertFalse(is(Integer.valueOf("0")).positive());
        assertFalse(is(Integer.valueOf("-1")).positive());
        Integer i = null;
        assertFalse(is(i).positive());
    }

    @Test
    public void testNegative() {
        assertFalse(is(1).negative());
        assertFalse((is(0)).negative());
        assertTrue((is(-1).negative()));
        assertFalse(is(Integer.valueOf("1")).negative());
        assertFalse(is(Integer.valueOf("0")).negative());
        assertTrue(is(Integer.valueOf("-1")).negative());
        Integer i = null;
        assertFalse(is(i).negative());
    }

    @Test
    public void testZero() {
        assertFalse(is(1).zero());
        assertTrue((is(0)).zero());
        assertFalse((is(-1).zero()));
        assertFalse(is(Integer.valueOf("1")).zero());
        assertTrue(is(Integer.valueOf("0")).zero());
        assertFalse(is(Integer.valueOf("-1")).zero());
        Integer i = null;
        assertFalse(is(i).zero());
    }

    @Test
    public void testEven() {
        assertTrue(is(0).even());
        assertTrue(is(2).even());
        assertTrue(is(Integer.valueOf("2")).even());
        assertFalse(is(1).even());
        assertFalse(is(Integer.valueOf("1")).even());
        Integer i = null;
        assertFalse(is(i).even());
    }

    @Test
    public void testOdd() {
        assertFalse(is(0).odd());
        assertFalse(is(2).odd());
        assertFalse(is(Integer.valueOf("2")).odd());
        assertTrue(is(1).odd());
        assertTrue(is(Integer.valueOf("1")).odd());
        Integer i = null;
        assertFalse(is(i).odd());
    }

    @Test
    public void testEq(){
        assertTrue(is(0).eq(Integer.valueOf("0")));
        assertTrue(is(new Integer(1000)).eq(new Integer(1000)));
        Integer i1 = null;
        Integer i2 = null;
        assertFalse(is(i1).eq(i2));
    }

    @Test
    public void testGt() {
        assertTrue(is(0).gt(Integer.valueOf("-1")));
        assertTrue(is(new Integer(1000)).gt(new Integer(999)));
        Integer i1 = null;
        Integer i2 = null;
        assertFalse(is(i1).gt(i2));
    }
}
