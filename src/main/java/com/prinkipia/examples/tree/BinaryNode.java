package com.prinkipia.examples.tree;

public class BinaryNode {
    Object value;

    BinaryNode left;
    BinaryNode right;


    public BinaryNode(final Object value, final BinaryNode left, final BinaryNode right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
}
