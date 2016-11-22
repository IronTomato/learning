package com.wnb.common.util.validator;

import junit.framework.Assert;
import org.junit.Test;

import static com.wnb.common.util.validator.Validators.is;

public class NumberValidatorTest {

    @Test
    public void testPositive() {
        Assert.assertTrue(is(123).odd());
    }
}
