package com.prinkipia.examples.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class TreeUtils {
    static void traversePreOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.value);
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }

    static void traverseInOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        traverseInOrder(node.left);
        System.out.println(node.value);
        traverseInOrder(node.right);
    }

    static void traversePostOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        traversePostOrder(node.left);
        traversePostOrder(node.right);
        System.out.println(node.value);
    }

    static void dfs(BinaryNode root) {
        if (root == null) {
            return;
        }

        Stack<BinaryNode> stack = new Stack<BinaryNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            BinaryNode node = stack.pop();
            dfs(node.left);
            dfs(node.right);
            System.out.println(node.value);

        }
    }

    static void bfs(BinaryNode root) {
        if (root == null) {
            return;
        }

        Queue<BinaryNode> queue = new ArrayDeque<BinaryNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode n = queue.remove();
            System.out.println(n.value);
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
        }
    }

    static int count(BinaryNode node) {
        if (node == null) {
            return 0;
        }

        return count(node.left) + count(node.right) + 1;
    }

    static int height(BinaryNode node) {
        if (node == null) {
            return -1;
        }

        return Math.max(height(node.left) + 1, height(node.right) + 1);
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
