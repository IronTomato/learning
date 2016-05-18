package org.wnb.test.guava;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.BoundType;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Range;
import com.google.common.primitives.Ints;

public class TestJoiner {

    @Test
    public void test() {
//        String str = Joiner.on(',').join(1, 2, 3, 4, 5, 6, 7, 8);
//        System.out.println(str);
//        Splitter.on(',').split(str).forEach(System.out::print);
        Splitter.on('#').withKeyValueSeparator(":")
                .split("member_user_name:门店账号#store_name:门店名称#quantity:退货数量#amount:退款金额").forEach((k, v) -> {
                    System.out.println(Joiner.on(',').join(k, v));
                });
        Range.range(1, BoundType.CLOSED, 10, BoundType.CLOSED);
    }
}
