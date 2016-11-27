package com.wnb.common.util.validator;

import org.junit.Test;

import static com.wnb.common.util.validator.Validators.is;
import static org.junit.Assert.*;

public class StringValidatorTest {

    @Test
    public void testBlank() {
        assertTrue(is("").blank());
        assertTrue(is("   ").blank());
        assertTrue(is("\n\t").blank());
        String str = null;
        assertTrue(is(str).blank());
    }

    @Test
    public void testEq(){
        assertTrue(is("").eq(""));
        assertTrue(is("a").eq("a"));
        assertTrue(is(new String("123")).eq(String.valueOf(123)));
    }

    @Test
    public void testLt() {
        assertTrue(is("1").lt("2"));
        assertTrue(is("abc").lt("bcd"));
    }
}
