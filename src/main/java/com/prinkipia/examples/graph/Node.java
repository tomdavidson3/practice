package com.prinkipia.examples.graph;

public class Node {
    public String name;
    public Node[] children;
    public boolean marked = false;

    public Node(final String name) {
        this.name = name;
    }
}
