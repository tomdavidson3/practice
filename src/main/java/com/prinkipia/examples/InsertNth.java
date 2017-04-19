package com.prinkipia.examples;

public class InsertNth {
    /*
  Insert Node at a given position in a linked list
  head can be NULL
  First element in the linked list is at position 0
  Node is defined as
  */
    static class Node {
        int data;
        Node next;
    }


    static Node InsertNth(Node head, int data, int position) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        if (head == null) {
            Node n = new Node();
            n.data = data;
            n.next = null;
            return n;
        }
        else {
            Node n = head.next;
            Node p = head;

            int i = 0;
            while (n != null && i <= position) {
                p = n;
                n = n.next;
                i++;
            }

            Node a = new Node();
            a.data = data;
            a.next = p.next;

            p.next = a;

            return head;
        }
    }

    public static void main(String[] args) {
        Node head = new Node();
        head.data = 1;
        head.next = null;

        System.out.println(InsertNth(head, 2, 1));
    }
}
