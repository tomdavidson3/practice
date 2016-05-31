package com.prinkipia.examples;

import java.util.LinkedList;
import java.util.Queue;

import com.prinkipia.examples.graph.Node;

public class RouteBetweenNodes {
    public static boolean bfs(Node start, Node end) {
        if (start == end) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        start.marked = true;

        queue.add(start);
        while (!queue.isEmpty()) {
            Node r = queue.remove();

            if (r.children != null) {
                for (Node child : r.children) {
                    if (!child.marked) {
                        if (child == end) {
                            return true;
                        }
                        child.marked = true;
                        queue.add(child);
                    }
                }
                r.marked = true;
            }
        }

        return false;
    }

    public static boolean dfs(Node start, Node end) {
        if (start == end) {
            return true;
        }

        start.marked = true;

        for (Node child : start.children) {
            if (!child.marked) {
                if (dfs(child, end)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node graphA = new Node("foo");
        graphA.children = new Node[] { new Node("bar") };
        graphA.children[0].children = new Node[] { new Node("biz") };

        System.out.println(bfs(graphA, graphA.children[0].children[0]));
    }
}
