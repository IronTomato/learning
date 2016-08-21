package com.wnb.leetcode._292_NimGame;

import java.util.HashSet;

public class Solution {
    public boolean canWinNim(int n) {
        return n >> 2 << 2 != n;
    }
}