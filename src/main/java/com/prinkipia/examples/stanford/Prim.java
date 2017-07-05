package com.prinkipia.examples.stanford;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Prim {
    static class Graph {
        private Map<Integer, Set<Edge>> adj;

        Graph(int size) {
            adj = new HashMap<>(size);
            for (int i = 1; i <= size; i++) {
                adj.put(i, new HashSet<>());
            }
        }

        void addEdge(int u, int v, int cost) {
            Edge edge = new Edge(u, v, cost);
            Set<Edge> fromEdges = adj.get(u);
            fromEdges.add(edge);

            Set<Edge> toEdges = adj.get(v);
            toEdges.add(new Edge(v, u, cost));
        }

        Set<Edge> getEdges(int vertex) {
            return adj.get(vertex);
        }
    }

    static class Edge implements Comparable<Edge> {
        int cost;
        int u;
        int v;

        public Edge(final int u, final int v, final int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(final Edge o) {
            return Integer.compare(cost, o.cost);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "cost=" + cost +
                    ", u=" + u +
                    ", v=" + v +
                    '}';
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final Edge edge = (Edge) o;
            return u == edge.u &&
                    v == edge.v;
        }

        @Override
        public int hashCode() {
            return Objects.hash(u, v);
        }
    }

    public static void mst(Graph g, int start) {
        Set<Integer> X = new HashSet<>();
        X.add(start);

        Set<Integer> V = new HashSet<>();
        V.addAll(g.adj.keySet());

        Set<Edge> T = new HashSet<>();

        while (!X.equals(V)) {
            Edge e = findMin(g, X);
            T.add(e);
            X.add(e.v);
        }

        int cost = 0;
        for (Edge e : T) {
            cost += e.cost;
        }
        System.out.println(cost);
    }

    private static Edge findMin(final Graph g, final Set<Integer> X) {
        PriorityQueue<Edge> availableEdges = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        for (int key : g.adj.keySet()) {
            for (Edge e : g.getEdges(key)) {
                if (X.contains(e.u) && !X.contains(e.v)) {
                    availableEdges.add(e);
                }
            }
        }
        return availableEdges.remove();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(args[0]));
        int numNodes = scanner.nextInt();
        int numEdges = scanner.nextInt();

        Graph g = new Graph(numNodes);

        while (scanner.hasNext()) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int cost = scanner.nextInt();

            g.addEdge(u, v, cost);
        }

        mst(g, 1);

        System.out.println();
    }
}
