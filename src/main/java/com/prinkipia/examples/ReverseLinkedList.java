package com.prinkipia.examples;

import java.util.Stack;

public class ReverseLinkedList {
    /*

     Reverse a linked list and return pointer to the head
     The input list will have at least one element
     Node is defined as
            */
     static class Node {
        int data;
        Node next;
     }

    // This is a "method-only" submission.
    // You only need to complete this method.
    static Node Reverse(Node node) {
        Node head = null;

        // loop through the existing list and create a new one, but always insert the next data at head of the new list
        // thus reversing it
        while (node != null) {
            Node n = new Node();
            n.data = node.data;
            n.next = head;
            head = n;

            node = node.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node n = new Node();
        n.data = 1;

        n.next = new Node();
        n.next.data = 2;

        Node reverseNode = Reverse(n);
        System.out.println(reverseNode);
    }
}
