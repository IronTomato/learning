package com.wnb.leetcode._344_ReverseString;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase {

    @Test
    public void test1() {
        Solution solution = new Solution();
        assertEquals("olleh", solution.reverseString("hello"));
    }
    
    @Test
    public void test2() {
        Solution2 solution = new Solution2();
        assertEquals("olleh", solution.reverseString("hello"));
    }

}
