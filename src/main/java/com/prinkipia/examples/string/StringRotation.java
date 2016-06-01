package com.prinkipia.examples.string;

public class StringRotation {
    public static boolean isSubString(String s1, String s2) {
        String rotated = s2;
        for (int i = 0; i < s2.length(); i++) {
            rotated = rotateOnce(rotated);
            if (rotated.equals(s1)) {
                return true;
            }
        }
        return false;
    }

    // prepend last character
    public static String rotateOnce(String str) {
        return str.substring(str.length() - 1) + str.substring(0, str.length() - 1);
    }


    public static boolean isRotation(String s1, String s2) {
        String s1s1 = s1 + s1;
        if (s1s1.contains(s2)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubString("tom", "mto"));
        System.out.println(isSubString("tom", "tmo"));
        System.out.println(isSubString("waterbottle", "erbottlewat"));
        System.out.println(isRotation("waterbottle", "erbottlewat"));
    }
}
