package com.wnb.test.guava;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.common.base.Splitter;

public class TestSplitter {

    @Test
    public void test() {
        Splitter.on("/").omitEmptyStrings().split("aaa/").forEach(System.out::println);
    }

}
