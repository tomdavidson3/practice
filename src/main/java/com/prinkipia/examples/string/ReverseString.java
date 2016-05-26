package com.prinkipia.examples.string;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverse(args[0]));
    }

    private static String reverse(final String arg) {
        char[] reversed = new char[arg.length()];
        int index = arg.length();
        for (char c : arg.toCharArray()) {
            reversed[--index] = c;
        }
        return new String(reversed);
    }
}
