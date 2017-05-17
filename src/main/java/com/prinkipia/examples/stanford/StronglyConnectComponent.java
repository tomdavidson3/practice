package com.prinkipia.examples.stanford;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StronglyConnectComponent {
    private static class Graph {
        private List<Integer>[] adj;
        private int size;
        int[] f;
        int[] leader;
        boolean[] visited;
        int t = 0;
        Integer s = null;

        public Graph(int size) {
            this.size = size;
            adj = new List[size + 1];

            for (int i = 1; i < adj.length; i++) {
                adj[i] = new LinkedList<>();
            }

            f = new int[size + 1];
            leader = new int[size + 1];
            visited = new boolean[size + 1];
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        List<Integer> getVertices(int j) {
            return adj[j];
        }

        int[] dfsLoop() {
            for (int i = size; i > 0; i--) {
                if (!visited[i]) {
                    s = i;
                    dfs(i);
                }
            }
            return f;
        }

        int[] dfsLoop(int[] v) {
            for (int i = size; i > 0; i--) {
                if (!visited[v[i]]) {
                    s = v[i];
                    dfs(v[i]);
                }
            }
            return v;
        }

        void dfs(int i) {
            visited[i] = true;
            leader[i] = s;
            for (int j : getVertices(i)) {
                if (!visited[j]) {
                    dfs(j);
                }
            }
            t++;
            f[i] = t;
        }

        public void replace(final int[] f) {

        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(args[0]));
        int size = Integer.parseInt(args[1]);

        Graph graph = new Graph(size);
        Graph graphReversed = new Graph(size);

        while (scanner.hasNext()) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();

            graph.addEdge(v, w);
            graphReversed.addEdge(w, v);
        }

        int[] f = graphReversed.dfsLoop();
        graph.replace(f);

        graph.dfsLoop(f);
    }

}
