package com.wnb.common.util.validator;

import junit.framework.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

import static com.wnb.common.util.validator.Validators.is;

public class NumberValidatorTest {

    @Test
    public void testPositive() {
//        Assert.assertTrue(is(123).lt(222));
        Pattern pattern = Pattern.compile("\\d");
        Assert.assertTrue(is("12345").contains(pattern));
        Assert.assertTrue(is(0.0).lte(0.0));
    }
}
