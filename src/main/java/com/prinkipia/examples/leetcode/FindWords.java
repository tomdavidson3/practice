package com.prinkipia.examples.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindWords {
    public String[] findWords(String[] words) {
        List<Set<Character>> keyboard = new ArrayList<>();
        keyboard.add(new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p')));
        keyboard.add(new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l')));
        keyboard.add(new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm')));

        List<String> foundWords = new ArrayList<>();
        for (Set<Character> row : keyboard) {
            for (String word : words) {
                boolean foundWord = true;
                for (char c : word.toCharArray()) {
                    char lc = Character.toLowerCase(c);
                    if (!row.contains(lc)) {
                        foundWord = false;
                        break;
                    }
                }
                if (foundWord) {
                    foundWords.add(word);
                }
            }
        }
        return foundWords.toArray(new String[foundWords.size()]);
    }

    public static void main(String[] args) {
        String[] words = { "Hello", "Alaska", "Dad", "Peace" };
        new FindWords().findWords(words);
    }
}
