package com.wnb.common.util.validator;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static com.wnb.common.util.validator.Validators.is;

public class CollectionValidatorTest {
    @Test
    public void testContains(){
        Assert.assertFalse(is(new ArrayList<String>()).contains(""));

    }
}
