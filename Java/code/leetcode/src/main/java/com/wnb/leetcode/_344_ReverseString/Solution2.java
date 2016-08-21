package com.wnb.leetcode._344_ReverseString;

public class Solution2 {
    public String reverseString(String s) {
        if (null == s || s.length() < 2) {
            return s;
        }
        int l = s.length();
        char[] chars = new char[l];
        for (int i = 0; i < l; chars[i++] = s.charAt(l - i));
        return new String(chars);
    }
}
