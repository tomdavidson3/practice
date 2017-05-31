package com.prinkipia.examples.stanford;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Kosaraju {
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency List

    //Constructor
    Kosaraju(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // A recursive function to print DFS starting from v
    void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        int n;

        // Recur for all the vertices adjacent to this vertex
        for (final Integer integer : adj[v]) {
            n = integer;
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    // Function that returns reverse (or transpose) of this graph
    Kosaraju getTranspose() {
        Kosaraju g = new Kosaraju(V);
        for (int v = 0; v < V; v++) {
            // Recur for all the vertices adjacent to this vertex
            for (final Integer integer : adj[v]) {
                g.adj[integer].add(v);
            }
        }
        return g;
    }

    void fillOrder(int v, boolean visited[], Stack stack) {
        // Mark the current node as visited and print it
        visited[v] = true;

        // Recur for all the vertices adjacent to this vertex
        for (final Integer n : adj[v]) {
            if (!visited[n]) {
                fillOrder(n, visited, stack);
            }
        }

        // All vertices reachable from v are processed by now,
        // push v to Stack
        stack.push(new Integer(v));
    }

    // The main function that finds and prints all strongly
    // connected components
    void printSCCs() {
        Stack stack = new Stack();

        // Mark all the vertices as not visited (For first DFS)
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        // Fill vertices in stack according to their finishing
        // times
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                fillOrder(i, visited, stack);
            }
        }

        // Create a reversed graph
        Kosaraju gr = getTranspose();

        // Mark all the vertices as not visited (For second DFS)
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        // Now process all vertices in order defined by Stack
        while (!stack.empty()) {
            // Pop a vertex from stack
            int v = (int) stack.pop();

            // Print Strongly connected component of the popped vertex
            if (!visited[v]) {
                gr.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }

    // Driver method
    public static void main(String args[]) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(args[0]));
        int size = Integer.parseInt(args[1]);

        Kosaraju graph = new Kosaraju(size);

        while (scanner.hasNext()) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;

            graph.addEdge(v, w);
        }

        System.out.println("Following are strongly connected components " +
                "in given graph ");
        graph.printSCCs();
    }
}
