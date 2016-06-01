package com.wnb.leetcode._328_OddEvenLinkedList;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode cursor = head.next;
        ListNode lastMoved = head;
        ListNode moving;

        boolean flag = true;
        while (cursor.next != null) {
            if (flag) {
                moving = cursor.next;
                cursor.next = moving.next;
                moving.next = lastMoved.next;
                lastMoved.next = moving;
                lastMoved = moving;
            } else {
                cursor = cursor.next;
            }
            flag = !flag;
        }

        return head;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}