package com.prinkipia.examples;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Tom on 5/28/2016.
 */
public class RemoveNthNodeFromLinkedList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        for (int i=0; i < n-1; i++) {
            node = head.next;
        }

        if (node.next != null) {
            node.next = node.next.next;
        }
        else {
            return node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        //System.out.println(new RemoveNthNodeFromLinkedList().removeNthFromEnd(listNode1, 2));

        System.out.println(new RemoveNthNodeFromLinkedList().removeNthFromEnd(listNode2, 1));


    }
}
