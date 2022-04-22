package com.xingxin.leetcode.linked;

/**
 * @author liuxh
 * @date 2021/6/5
 */
public class DeleteNode {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void deleteNode(ListNode node){
        //把要删除结点的下一个结点的值赋给要删除的结点
        node.val = node.next.val;
        //然后删除下一个结点
        node.next = node.next.next;
    }

    public static void main(String[] args) {

    }
}
