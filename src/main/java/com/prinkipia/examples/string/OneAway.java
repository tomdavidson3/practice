package com.prinkipia.examples.string;

public class OneAway {
    static boolean numEdits(String source, String target) {
        if (source == null || target == null) {
            throw new NullPointerException();
        }

        if (source.equals(target)) {
            return true;
        }

        int diff = target.length() - source.length();
        if (diff == 0) {
            // if strings are same length then check there is only one difference in characters
            return numDifferences(source, target) == 1;
        }
        if (diff == 1) {
            return checkInsert(source, target);
        }
        if (diff == -1) {
            return checkInsert(target, source);
        }
        return false;
    }

    private static boolean checkInsert(final String source, final String target) {
        if (target.startsWith(source)) {
            return true;
        }

        int j = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i + j)) {
                j++;
            }
        }
        return j == 1;
    }

    private static int numDifferences(final String source, final String target) {
        int count = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numEdits("",""));
        System.out.println(numEdits("pale", "pale"));
        System.out.println(numEdits("pale", "pales"));
        System.out.println(numEdits("pales", "pale"));
        System.out.println(numEdits("pale", "spale"));
        System.out.println(numEdits("pale", "bale"));
        System.out.println(numEdits("pale", "bake"));
        System.out.println(numEdits("pale", "ba"));
    }
}
