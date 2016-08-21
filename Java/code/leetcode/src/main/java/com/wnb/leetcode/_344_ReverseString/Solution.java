package com.wnb.leetcode._344_ReverseString;

public class Solution {
    public String reverseString(String s) {
        return null == s ? s : new StringBuilder(s).reverse().toString();
    }
}