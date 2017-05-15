package com.prinkipia.examples.stanford;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StronglyConnectComponent {
    private static class Graph {
        private List<Integer>[] adj;
        private int size;

        public Graph(int size) {
            this.size = size;
            adj = new List[size + 1];

            for (int i = 0; i <= size; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        int size() {
            return size;
        }

        List<Integer> getVertices(int j) {
            return adj[j];
        }
    }


    static int t = 0;
    static Integer s = null;
    static int[] f;
    static boolean[] visited;

    private static void dfsLoop(final Graph graph) {
        f = new int[graph.size() + 1];
        visited = new boolean[graph.size() + 1];

        for (int i = graph.size(); i > 0; i--) {
            if (!visited[i]) {
                s = i;
                dfs(graph, i, visited);
            }
            f[i] = s;
        }
        System.out.println(f);
    }

    private static void dfs(Graph g, int i, boolean[] visited) {
        visited[i] = true;
        f[i] = s;
        for (int j : g.getVertices(i)) {
            dfs(g, j, visited);
        }
        t++;
        f[i] = t;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(args[0]));

        Graph graph = new Graph(875714);
        Graph graphReversed = new Graph(875714);

        while (scanner.hasNext()) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();

            graph.addEdge(v, w);
            graphReversed.addEdge(w, v);
        }

        dfsLoop(graphReversed);
    }

}
