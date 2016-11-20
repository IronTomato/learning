package com.wnb.common.util.validator;


import org.junit.Test;
import static org.junit.Assert.*;
import static com.wnb.common.util.validator.BooleanConverter.*;
import static com.wnb.common.util.validator.Wrappers.*;


public class StringWrapperTest {

    @Test
    public void testInObject() {
        assertTrue(is("toString").in(""));
    }
}
