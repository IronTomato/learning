package org.wnb.test.util;

import static org.junit.Assert.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.wnb.util.MD5;
import org.wnb.util.RandomCode;

public class MD5Test {

    @Test
    public void test() {
        String str = RandomCode.random(10);
        System.out.println(str);
        System.out.println(MD5.encode(str));
        System.out.println(DigestUtils.md5Hex(str));
    }

}
