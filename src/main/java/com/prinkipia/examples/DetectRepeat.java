package com.prinkipia.examples;

import java.util.HashMap;
import java.util.Map;

public class DetectRepeat {
    public static void main(String[] args) {
        System.out.println(hasRepeatingCharacters(args[0]));
    }

    private static boolean hasRepeatingCharacters(final String arg) {
        Map<Character, Integer> counts = new HashMap<Character, Integer>();
        for (int i = 0; i < arg.length(); i++) {
            char c = arg.charAt(i);
            Integer count = counts.get(c);
            if (count == null) {
                count = 1;
                counts.put(c, count);
            }
            else {
                counts.put(c, ++count);
            }
        }
        for (Integer value : counts.values()) {
            if (value > 1) {
                return true;
            }
        }
        return false;
    }
}
