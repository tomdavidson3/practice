package com.prinkipia.examples.boggle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BoggleSolver {
    private BoggleBoard board;
    Trie trie = new Trie();

    public BoggleSolver(Iterable<String> words, BoggleBoard board) {
        for (String word : words) {
            if (word.length() > 2) {
                trie.insert(word);
            }
        }
        this.board = board;
    }

    public Set<String> findAllWords() {
        Set<String> words = new TreeSet<String>();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                boolean[][] visited = new boolean[board.getSize()][board.getSize()];
                dfs("", i, j, visited, words);
            }
        }
        return words;
    }

    private void dfs(String prefix, int i, int j, boolean[][] visited, Set<String> words) {
        if (i < 0 || j < 0 || i >= board.getSize() || j >= board.getSize()) {
            return;
        }

        // can't visit a cell more than once
        if (visited[i][j]) {
            return;
        }

        // not allowed to reuse a letter
        visited[i][j] = true;

        // found a word
        prefix = prefix + board.getLetter(i, j);

        // key to efficiency of backtracking algorithm
        if (!trie.startsWith(prefix)) {
            return;
        }

        if (trie.isWord(prefix)) {
            words.add(prefix);
        }

        // consider all neighbors
        for (int ii = -1; ii <= 1; ii++) {
            for (int jj = -1; jj <= 1; jj++) {
                dfs(prefix, i + ii, j + jj, visited, words);
            }
        }

        visited[i][j] = false;
    }

    public static void main(String[] args) throws IOException {
        char[][] bestBoard = new char[][] {
                { 'G', 'N', 'E', 'S' },
                { 'S', 'R', 'I', 'P' },
                { 'E', 'T', 'A', 'L' },
                { 'T', 'S', 'E', 'B' }
        };

        BoggleBoard board = new BoggleBoard(bestBoard, 4);

        BoggleSolver solver = new BoggleSolver(loadDictionary(args[0]), board);

        board.printBoard();
        System.out.println(solver.findAllWords());
    }

    private static Collection<String> loadDictionary(final String file) throws IOException {
        List<String> words;
        try (Stream<String> stream = Files.lines(Paths.get(file))) {
            words = stream.collect(Collectors.toList());
        }
        return words;
    }
}
