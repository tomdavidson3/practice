package com.prinkipia.examples.boggle;

import java.util.Map;
import java.util.TreeMap;

public class TrieNode {
    char aChar;
    boolean isLeaf;

    Map<Character, TrieNode> children = new TreeMap<Character, TrieNode>();

    public TrieNode() {
    }

    public TrieNode(final char aChar) {
        this.aChar = aChar;
    }
}
