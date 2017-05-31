package com.prinkipia.examples;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * https://class.coursera.org/algo/quiz/attempt?quiz_id=52
 */
public class MinCut {
    Map<Integer, List<Integer>> adjList;
    List<Integer> vList;
    int size;
    int mincut = Integer.MAX_VALUE;
    Random r = new Random();

    public MinCut() {
        init();
    }

    void init() {
        adjList = new HashMap<>();
        vList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new InputStreamReader(this.getClass().
                    getClassLoader().getResourceAsStream("kargerMincut.txt")));
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                String num[] = s.split("\\t");
                List<Integer> adj = new ArrayList<>();
                for (int i = 1; i < num.length; i++) {
                    adj.add(Integer.parseInt(num[i]));
                }
                adjList.put(Integer.parseInt(num[0]), adj);
                vList.add(Integer.parseInt(num[0]));
            }
            size = vList.size();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    void calculate() {
        while (adjList.size() > 2) {
            //Find the start_vertex of a random edge
            int vIndex = vList.get(r.nextInt(vList.size()));
            List<Integer> v = adjList.get(vIndex);
            //Find the end_vertex of a random edge
            int dIndex = v.get(r.nextInt(v.size()));
            List<Integer> d = adjList.get(dIndex);
            /*
			 * start_vertex = start_vertex U end_vertex
			 * 1. Find all vertices connected to end_vertex as aux vertices
			 * 2. Remove the end_vertex from the vertex list for each aux vertex
			 * 3. Add the start_vertex from the vertex list for each aux vertex
			 * 4. Add the aux vertices to the start_vertex list
			 * 5. Remove the end_vertex list from adjList
			 * 6. Remove self loops in start_vertex
			 */
            for (Iterator<Integer> iterator = d.iterator(); iterator.hasNext(); ) {
                int auxIndex = iterator.next();
                List<Integer> aux = adjList.get(auxIndex);
                //2. Remove the end_vertex from the vertex list for each aux vertex
                while (aux.remove(new Integer(dIndex))) {
                    ;
                }
                //3. Add the start_vertex from the vertex list for each aux vertex
                aux.add(new Integer(vIndex));
                //4. Add the aux vertices to the start_vertex list
                v.add(auxIndex);
            }
            //5. Remove the end_vertex list from adjList
            adjList.remove(dIndex);
            vList.remove(new Integer(dIndex));
            //6. Remove self loops in start_vertex
            while (v.remove(new Integer(vIndex))) {
                ;
            }
        }
        mincut = Math.min(mincut, adjList.get(vList.get(0)).size());
    }

    void display() {
        List<Integer> sortedKeys = new ArrayList<>(adjList.keySet());
        for (Iterator<Integer> iterator = sortedKeys.iterator();
             iterator.hasNext(); ) {
            int i = iterator.next();
            System.out.print(i + " ");
            List<Integer> list = adjList.get(i);
            for (Iterator<Integer> iterator2 = list.iterator(); iterator2.hasNext(); ) {
                System.out.print(iterator2.next() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String args[]) {
        MinCut mincut = new MinCut();
        //Probability of finding a mincut is between 1/n^2,1/nlogn
        for (int i = 1; i <= mincut.size * mincut.size; i++) {
            mincut.init();
            mincut.calculate();
            System.out.println("Iteration " + i + " " + mincut.mincut);
        }
        System.out.println(mincut.mincut);
    }
}
