package com.prinkipia.examples.heap;

import com.prinkipia.examples.tree.BinaryNode;
import com.prinkipia.examples.tree.TreeUtils;

public class MinHeap {
    private BinaryNode<Comparable> root;

    public Comparable getMin() {
        if (root == null) {
            return null;
        }

        return root.getValue();
    }

    public void insert(Comparable value) {
        if (root == null) {
            root = new BinaryNode<>(value);
        }
        else {
            heapify(root.insertInOrder(value));
        }
    }

    private void heapify(BinaryNode<Comparable> node) {
        if (node.getParent() == null) {
            return;
        }

        if (node.getParent().getValue().compareTo(node.getValue()) <= 0) {
            // dont need to do anything, parent is already less than right node
            return;
        }
        Comparable temp = node.getParent().getValue();
        node.getParent().setValue(node.getValue());
        node.setValue(temp);
        heapify(node.getParent());
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(1.0);
        minHeap.insert(-1.0);
        minHeap.insert(3.0);
        minHeap.insert(4.0);
        minHeap.insert(10.0);

        TreeUtils.bfs(minHeap.root);
    }
}
