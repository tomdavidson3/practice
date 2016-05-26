package com.prinkipia.examples;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("one");
        stack.push("two");
        stack.push("three");

        for (String item : stack) {
            System.out.println(item);
        }

        reverseStack(stack);

        for (String item : stack) {
            System.out.println(item);
        }
    }

    private static void insertAtBottom(final Stack<String> stack, String item) {
        if (stack.empty()) {
            stack.push(item);
        }
        else {
            String temp = stack.pop();
            insertAtBottom(stack, item);
            stack.push(temp);
        }
    }

    private static void reverseStack(final Stack<String> stack) {
        if (!stack.empty()) {
            String item = stack.pop();
            reverseStack(stack);
            insertAtBottom(stack, item);
        }
    }
}
