package com.prinkipia.examples.tree;

public class BinaryNode<T extends Comparable> {
    private T value;
    private BinaryNode<T> left;
    private BinaryNode<T> right;
    private BinaryNode<T> parent;

    public BinaryNode(final T value) {
        this.value = value;
    }

    public BinaryNode(final T value, final BinaryNode<T> left, final BinaryNode<T> right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public BinaryNode<T> getParent() {
        return parent;
    }

    public void setParent(final BinaryNode<T> parent) {
        this.parent = parent;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(final BinaryNode<T> left) {
        this.left = left;
        if (left != null) {
            left.setParent(this);
        }
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setRight(final BinaryNode<T> right) {
        this.right = right;
        if (right != null) {
            right.setParent(this);
        }
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public BinaryNode<T> insertInOrder(T d) {
        if (d.compareTo(value) <= 0) {
            if (left == null) {
                BinaryNode<T> node = new BinaryNode<T>(d);
                setLeft(node);
                return node;
            }
            else {
                return left.insertInOrder(d);
            }
        }
        else {
            if (right == null) {
                BinaryNode<T> node = new BinaryNode<T>(d);
                setRight(node);
                return node;
            }
            else {
                return right.insertInOrder(d);
            }
        }
    }
}
