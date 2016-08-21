344. Reverse String
====================

题目
----
Write a function that takes a string as input and returns the string reversed.

####Example:  
Given s = "hello", return "olleh".

解法1
-----
使用`StringBuilder`提供的`reverse()`方法

	public class Solution {
	    public String reverseString(String s) {
	        return null == s ? s : new StringBuilder(s).reverse().toString();
	    }
	}

解法2
-----
使用自带API有点偷懒，手动实现的话就是将字符串看成字符数组，逆序遍历然后构造一个新字符串

	public class Solution2 {
	    public String reverseString(String s) {
	        int l = s.length();
	        if (null == s || l < 2) {
	            return s;
	        }
	        char[] chars = new char[l];
	        for (int i = 0; i < l; i++) {
	            chars[i] = s.charAt(l - 1 - i);
	        }
	        return new String(chars);
	    }
	}

