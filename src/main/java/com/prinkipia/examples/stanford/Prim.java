package com.prinkipia.examples.stanford;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Prim {
    static class Graph {
        private Map<Integer, List<Edge>> adj;

        Graph(int size) {
            adj = new HashMap<>(size);
            for (int i = 1; i <= size; i++) {
                adj.put(i, new ArrayList<>());
            }
        }

        void addEdge(int u, int v, int cost) {
            List<Edge> fromEdges = adj.get(u);
            fromEdges.add(new Edge(u, v, cost));
        }

        List<Edge> getEdges(int vertex) {
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
    }

    public static void mst(Graph g, int start) {
        Set<Integer> unvisited = new HashSet<>();
        unvisited.addAll(g.adj.keySet());
        unvisited.remove(start);

        Queue<Edge> edgesAvailable = new PriorityQueue<>();

        List<Edge> path = new ArrayList<>();

        int cost = 0;
        int vertex = start;
        while (!unvisited.isEmpty()) {
            for (Edge edge : g.getEdges(vertex)) {
                if (unvisited.contains(edge.v)) {
                    edgesAvailable.add(edge);
                }
            }
            Edge minCostEdge = edgesAvailable.remove();
            cost += minCostEdge.cost;
            path.add(minCostEdge);
            vertex = minCostEdge.v;
            unvisited.remove(vertex);
        }

        System.out.printf("cost: " + cost);
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
