package com.prinkipia.examples;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tom on 5/28/2016.
 */
public class DetectLinkedListCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return null;
        }
        Set<ListNode> visitedNodes = new HashSet<>();

        ListNode node = head;
        visitedNodes.add(node);
        while ((node = node.next) != null) {
            if (visitedNodes.contains(node)) {
                return node;
            } else {
                visitedNodes.add(node);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode1;
        System.out.println(new DetectLinkedListCycle().detectCycle(listNode1));
    }
}
