package com.prinkipia.examples.stanford;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class Prim {
    static class Graph {
        private int v;   // No. of vertices
        private LinkedList<Edge>[] adj; //Adjacency List

        //Constructor
        Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList<>();
            }
        }

        //Function to add an edge into the graph
        void addEdge(int u, int v, int cost) {
            adj[v].add(new Edge(u, v, cost));
        }
    }

    static class Edge {
        int cost;
        int u;
        int v;

        public Edge(final int u, final int v, final int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }

    void mst(Graph g) {
        Set<Integer> x = new LinkedHashSet<>(); // vertices spanned by tree-so-far T
        x.add(g.adj[0].getFirst().u);

        Set<Integer> t = new LinkedHashSet<>();

        while (x.size() != 0) {
            Edge e = findMin(x, g);
            t.add(e);
            x.add(e.vertex);
        }

    }

    private Edge findMin(final Set<Integer> x, final Graph g) {
        for (LinkedList<Edge> node : g.adj) {
            for (Edge e : node) {
                if (x.contains(e.vertex) && !x.contains(e.))
            }
        }
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

        System.out.println();
    }
}
