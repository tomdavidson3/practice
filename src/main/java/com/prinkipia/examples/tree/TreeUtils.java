package com.prinkipia.examples.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class TreeUtils {
    public static void traversePreOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.getValue());
        traversePreOrder(node.getLeft());
        traversePreOrder(node.getRight());
    }

    public static void traverseInOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        traverseInOrder(node.getLeft());
        System.out.println(node.getValue());
        traverseInOrder(node.getRight());
    }

    public static void traversePostOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        traversePostOrder(node.getLeft());
        traversePostOrder(node.getRight());
        System.out.println(node.getValue());
    }

    public static void dfs(BinaryNode root) {
        if (root == null) {
            return;
        }

        Stack<BinaryNode> stack = new Stack<BinaryNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            BinaryNode node = stack.pop();
            dfs(node.getLeft());
            dfs(node.getRight());
            System.out.println(node.getValue());

        }
    }

    public static void bfs(BinaryNode root) {
        if (root == null) {
            return;
        }

        Queue<BinaryNode> queue = new ArrayDeque<BinaryNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode n = queue.remove();
            System.out.println(n.getValue());
            if (n.getLeft() != null) {
                queue.add(n.getLeft());
            }
            if (n.getRight() != null) {
                queue.add(n.getRight());
            }
        }
    }

    public static int count(BinaryNode node) {
        if (node == null) {
            return 0;
        }

        return count(node.getLeft()) + count(node.getRight()) + 1;
    }

    public static int height(BinaryNode node) {
        if (node == null) {
            return -1;
        }

        return Math.max(height(node.getLeft()) + 1, height(node.getRight()) + 1);
    }

    public static void main(String[] args) {
        BinaryNode node = new BinaryNode("0", new BinaryNode("1", null, null), new BinaryNode("2", new BinaryNode("3", null, null), null));

        System.out.println("height: " + height(node));
        System.out.println("count: " + count(node));
//        traversePreOrder(node);
//        traverseInOrder(node);
//        traversePostOrder(node);

        System.out.println("dfs:");
        dfs(node);

        System.out.println("bfs:");
        bfs(node);
    }

}
