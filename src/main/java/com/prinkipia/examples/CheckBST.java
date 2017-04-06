package com.prinkipia.examples;

public class CheckBST {
    private static class Node {
        int data;
        Node left;
        Node right;
    }

    boolean checkBST(Node root) {
        if (root == null) {
            return true;
        }

        if (root.left != null) {
            if (root.left.data < root.data) {
                return checkBST(root.left);
            }
            else {
                return false;
            }
        }

        if (root.right != null) {
            if (root.right.data > root.data) {
                return checkBST(root.right);
            }
            else {
                return false;
            }
        }

        return root.left.data < root.data && root.right.data < root.data;
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.data = 1;

        root.left = new Node();
        root.left.data = 0;

        root.right = new Node();
        root.right.data = 2;


        System.out.println(new CheckBST().checkBST(root));
    }
}
