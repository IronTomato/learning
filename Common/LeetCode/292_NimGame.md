292. Nim Game
=============

题目
-----
You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.

思路
-----
4个石头时，取石头的人没法赢，于是，如果你能把石头取的剩下4个，你就赢了，所以5,6,7个石头时你都可以赢，8个石头没法赢，以此类推，于是问题变成简单的n是否能被4整除，能整除则输，否则赢

解法1
-------

	public class Solution {
	    public boolean canWinNim(int n) {
	        return n % 4 != 0;
	    }
	}

解法2
-----
4刚好是2的2次方，能被4整除的数有个特征，二进制末尾2位为0，将n按位与上3(二进制11)，可以取到n的末二位，判断是否为0，由于按位与运算符&优先级低于!=，因此括号是必须的

	public class Solution {
	    public boolean canWinNim(int n) {
	        return (n & 3) != 0;
	    }
	}

解法3
----
跟解法2思路类似，将n右移2位将丢弃n的末二位，然后左移2位将在末位补0，如果转换后的数与n相同，则说明n的末二位是0

	public class Solution {
	    public boolean canWinNim(int n) {
	        return n >> 2 << 2 != n;
	    }
	}