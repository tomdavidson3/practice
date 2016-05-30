package com.prinkipia.examples;

/**
 * Created by Tom on 5/28/2016.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        int carryAmount = 0;
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        do {
            int sum = node1.val + node2.val;
            head.val = sum % 10 + dummy.val;
            carryAmount = sum / 10;
            dummy.next = new ListNode(carryAmount);
            node1 = node1.next;
            node2 = node2.next;
            dummy = dummy.next;
        } while (node1 != null);

       // dummy.next = new ListNode(carryAmount);

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);

        System.out.println(new AddTwoNumbers().addTwoNumbers(listNode1, listNode2).val);
    }
}
