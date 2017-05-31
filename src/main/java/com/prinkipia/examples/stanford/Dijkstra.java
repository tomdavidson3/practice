package com.prinkipia.examples.stanford;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Dijkstra {
    public static class Graph {

        private Map<String, Node> graph = new LinkedHashMap<>();

        public void addNode(Node nodeA) {
            graph.put(nodeA.getName(), nodeA);
        }

        public Node getNode(String node) {
            return graph.get(node);
        }
    }

    public static class Node {

        private String name;

        private List<Node> shortestPath = new LinkedList<>();

        private Integer distance = Integer.MAX_VALUE;

        Map<Node, Integer> adjacentNodes = new HashMap<>();

        public void addDestination(Node destination, int distance) {
            adjacentNodes.put(destination, distance);
        }

        public Node(String name) {
            this.name = name;
        }

        // getters and setters


        public Map<Node, Integer> getAdjacentNodes() {
            return adjacentNodes;
        }

        public void setAdjacentNodes(final Map<Node, Integer> adjacentNodes) {
            this.adjacentNodes = adjacentNodes;
        }

        public Integer getDistance() {
            return distance;
        }

        public void setDistance(final Integer distance) {
            this.distance = distance;
        }

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public List<Node> getShortestPath() {
            return shortestPath;
        }

        public void setShortestPath(final List<Node> shortestPath) {
            this.shortestPath = shortestPath;
        }
    }

    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<Node, Integer> adjacencyPair :
                    currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(Node evaluationNode,
            Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(args[0]));

        Graph graph = new Graph();
        for (int i = 1; i < 201; i++) {
            graph.addNode(new Node("" + i));
        }

        while (scanner.hasNextLine()) {
            String row = scanner.nextLine();
            Scanner rowScanner = new Scanner(row);
            while (rowScanner.hasNext()) {
                String v = rowScanner.next();
                Node node = graph.getNode(v);
                if (node == null) {
                    node = new Node(v);
                    graph.addNode(node);
                }
                while (rowScanner.hasNext()) {
                    String token = rowScanner.next();
                    Scanner tokenScanner = new Scanner(token);
                    while (tokenScanner.hasNext()) {
                        String[] parts = tokenScanner.next().split(",");
                        Node aNode = graph.getNode(parts[0]);
                        if (aNode == null) {
                            aNode = new Node(parts[0]);
                        }
                        node.addDestination(aNode, Integer.parseInt(parts[1]));
                    }
                }
            }
        }

        calculateShortestPathFromSource(graph, graph.getNode("1"));

        int[] nodesToPrint = new int[] { 7, 37, 59, 82, 99, 115, 133, 165, 188, 197 };
        for (int n : nodesToPrint) {
            Node node = graph.getNode("" + n);
            System.out.print(node.getDistance() + ",");
        }
    }
}
